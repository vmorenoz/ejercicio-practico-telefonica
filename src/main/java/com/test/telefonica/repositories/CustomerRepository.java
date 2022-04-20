package com.test.telefonica.repositories;

import com.test.telefonica.entities.CustomerEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Long>{
}
