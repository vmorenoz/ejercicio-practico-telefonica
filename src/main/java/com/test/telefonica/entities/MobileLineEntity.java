package com.test.telefonica.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Table(name = "mobileLine")
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region = "mobileLine" )
public class MobileLineEntity extends BaseEntity{

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "line_status")
    private Boolean lineStatus;

    @Column(name = "line_type")
    private String lineType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    private PlanEntity plan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "mobileLine", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"mobileLine"})
    private List<MobileLineOfferEntity> mobileLineOffers;
}
