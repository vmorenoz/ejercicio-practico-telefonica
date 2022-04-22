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
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "mobile_line_offer")
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "mobileLineOffer")
public class MobileLineOfferEntity extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "mobile_line_id", referencedColumnName = "id")
    private MobileLineEntity mobileLine;

    @ManyToOne()
    @JoinColumn(name = "offer_id", referencedColumnName = "id")
    private OfferEntity offer;
}
