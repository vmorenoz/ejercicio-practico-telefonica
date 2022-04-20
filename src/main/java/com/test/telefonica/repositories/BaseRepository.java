package com.test.telefonica.repositories;

import com.test.telefonica.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<Entity extends BaseEntity, KeyType> extends JpaRepository<Entity, KeyType> {

}
