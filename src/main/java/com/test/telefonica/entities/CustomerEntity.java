package com.test.telefonica.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "customer")
@Entity
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY, region = "customer" )
public class CustomerEntity extends BaseEntity {
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "birthday_date")
    private String birthdayDate;

}