package com.test.telefonica.services;

import com.test.telefonica.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<Entity extends BaseEntity, KeyType> {

    Entity getById(KeyType id);

    void save(Entity entity);

    void delete(Entity entity);

    List<Entity> listAll();

    Page<Entity> paginate(Pageable pageable);
}
