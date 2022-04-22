package com.test.telefonica.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "offer")
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region = "offer" )
public class OfferEntity extends BaseEntity{

    @Column
    private String code;

    @Column
    private String description;

    @Column(name = "valid_from")
    private Date validFrom;

    @Column(name = "valid_to")
    private Date validTo;
}
