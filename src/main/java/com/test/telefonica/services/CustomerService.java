package com.test.telefonica.services;

import com.test.telefonica.entities.CustomerEntity;

import java.util.Date;
import java.util.List;

public interface CustomerService extends BaseService<CustomerEntity, Long>{
    List<CustomerEntity> listByDocumentNumberAndDocumentType(String documentNumber, String documentType);

    List<CustomerEntity> listByOfferDate(Date dateFrom, Date dateTo);
}
