package com.test.telefonica.services.impl;

import com.test.telefonica.entities.CustomerEntity;
import com.test.telefonica.entities.MobileLineEntity;
import com.test.telefonica.entities.MobileLineOfferEntity;
import com.test.telefonica.repositories.CustomerRepository;
import com.test.telefonica.services.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<CustomerEntity, Long> implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
        customerRepository = repository;
    }

    @Override
    public List<CustomerEntity> listByDocumentNumberAndDocumentType(String documentNumber, String documentType) {
        List<CustomerEntity> customersList;

        customersList = customerRepository.findAllByDocumentNumberContainsAndDocumentTypeEquals(documentNumber, documentType);
        return customersList;
    }

    @Override
    public List<CustomerEntity> listByOfferDate(Date dateFrom, Date dateTo) {
        List<CustomerEntity> customersList;

        customersList = customerRepository.getAllWithAtLeastThreeLinesWithAtLeastOneOfferEachOneByOfferDateBetween(dateFrom, dateTo);

        customersList = customersList.stream()
                .filter(customer -> customer.getMobileLines().size() >= 3 && customer.getMobileLines().stream().allMatch(mobileLine -> mobileLine.getMobileLineOffers().size() >= 1))
                .map(this::mapCustomerMobileLinesWithOfferSoonToExpire)
                .collect(Collectors.toList());

        return customersList;
    }

    private CustomerEntity mapCustomerMobileLinesWithOfferSoonToExpire(CustomerEntity customer) {
        customer.setMobileLines(customer.getMobileLines().stream().map(this::getMobileLineWithOfferSoonToExpire).collect(Collectors.toList()));

        return customer;
    }

    private MobileLineEntity getMobileLineWithOfferSoonToExpire(MobileLineEntity mobileLine) {
        List<MobileLineOfferEntity> result = new ArrayList<>();

        result.add(mobileLine.getMobileLineOffers().stream()
                .min(Comparator.comparing(mobileLineOffer -> mobileLineOffer.getOffer().getValidTo().getTime())).orElse(null));

        mobileLine.setMobileLineOffers(result);

        return mobileLine;
    }

}
