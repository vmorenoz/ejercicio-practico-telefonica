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
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "plan")
@Entity
@SelectBeforeUpdate
@DynamicUpdate
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "plan")
public class PlanEntity extends BaseEntity {

    @Column()
    private String name;

    @Column()
    private BigDecimal price;

}
