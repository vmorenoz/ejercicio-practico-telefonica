package com.test.telefonica.services.impl;

import com.test.telefonica.entities.CustomerEntity;
import com.test.telefonica.repositories.CustomerRepository;
import com.test.telefonica.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<CustomerEntity, Long> implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
        customerRepository = repository;
    }
}
