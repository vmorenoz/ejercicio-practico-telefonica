package com.test.telefonica.services.impl;

import com.test.telefonica.entities.BaseEntity;
import com.test.telefonica.repositories.BaseRepository;
import com.test.telefonica.services.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Log4j2
public class BaseServiceImpl<Entity extends BaseEntity, KeyType> implements BaseService<Entity, KeyType> {

    private final BaseRepository<Entity, KeyType> repository;

    public BaseServiceImpl(BaseRepository<Entity, KeyType> repository) {
        this.repository = repository;
    }

    @Override
    public Entity getById(KeyType id) {
        try {
            return repository.getById(id);
        } catch (Exception ex) {
            log.error("There was an error getting the entity: {}", ex.getMessage());
        }
        return null;
    }

    @Override
    public void save(Entity entity) {
        try {
            repository.save(entity);
        } catch (Exception ex) {
            log.error("There was an error saving the entity: {}", ex.getMessage());
        }
    }

    @Override
    public void delete(Entity entity) {
        try {
            repository.delete(entity);
        } catch (Exception ex) {
            log.error("There was an error deleting the entity: {}", ex.getMessage());
        }
    }

    @Override
    public List<Entity> listAll() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            log.error("There was an error getting the entities list: {}", ex.getMessage());
        }
        return null;
    }

    @Override
    public Page<Entity> paginate(Pageable pageable) {
        try {
            return repository.findAll(pageable);
        } catch (Exception ex) {
            log.error("There was an error getting the entities page: {}", ex.getMessage());
        }
        return null;
    }
}
