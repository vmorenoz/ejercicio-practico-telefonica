package com.test.telefonica.services.impl;

import com.test.telefonica.entities.BaseEntity;
import com.test.telefonica.repositories.BaseRepository;
import com.test.telefonica.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BaseServiceImpl<Entity extends BaseEntity, KeyType> implements BaseService<Entity, KeyType> {

    private final BaseRepository<Entity, KeyType> repository;

    public BaseServiceImpl(BaseRepository<Entity, KeyType> repository) {
        this.repository = repository;
    }

    @Override
    public Entity getById(KeyType id) {
        return repository.getById(id);
    }

    @Override
    public void save(Entity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Entity entity) {
        repository.delete(entity);
    }

    @Override
    public List<Entity> listAll() {
        return repository.findAll();
    }

    @Override
    public Page<Entity> paginate(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
