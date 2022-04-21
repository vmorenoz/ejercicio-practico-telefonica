package com.test.telefonica.controllers;

import com.test.telefonica.entities.CustomerEntity;
import com.test.telefonica.services.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController extends BaseControllerImpl<CustomerEntity, Long> implements BaseController<CustomerEntity, Long> {

    private final CustomerService customerService;

    public CustomerController(CustomerService service) {
        super(service);
        customerService = service;
    }
}
