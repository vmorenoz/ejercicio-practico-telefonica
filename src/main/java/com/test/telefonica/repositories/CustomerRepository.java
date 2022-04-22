package com.test.telefonica.repositories;

import com.test.telefonica.entities.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAllByDocumentNumberContainsAndDocumentTypeEquals(String documentNumber, String documentType);

    @Query("select distinct(customer) from CustomerEntity customer join customer.mobileLines line join line.mobileLineOffers lineOffer join lineOffer.offer offer where offer.validTo between ?1 and ?2")
    List<CustomerEntity> getAllWithAtLeastThreeLinesWithAtLeastOneOfferEachOneByOfferDateBetween(Date dateFrom, Date dateTo);
}
