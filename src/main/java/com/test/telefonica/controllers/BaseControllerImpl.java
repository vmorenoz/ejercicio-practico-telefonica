package com.test.telefonica.controllers;

import com.test.telefonica.entities.BaseEntity;
import com.test.telefonica.services.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Log4j2
public class BaseControllerImpl<Entity extends BaseEntity, KeyType> implements BaseController<Entity, KeyType> {

    private final BaseService<Entity, KeyType> service;

    public BaseControllerImpl(BaseService<Entity, KeyType> service) {
        this.service = service;
    }

    @Override
    @PostMapping("paginate")
    public ResponseEntity<?> paginate(@RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "10") Integer size) {
        try {
            Pageable paginator = PageRequest.of(page, size, Sort.by(Sort.Order.desc("id")));
            return new ResponseEntity<>(service.paginate(paginator), HttpStatus.OK);
        } catch (Exception ex) {
            log.error("There was an error: {}", ex.getMessage());
            return new ResponseEntity<>("There was an error on the server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(HttpServletRequest request, @RequestBody Entity entity) {
        try {
            service.save(entity);
            return new ResponseEntity<>("Entity saved successfully", HttpStatus.OK);
        } catch (Exception ex) {
            log.error("There was an error: {}", ex.getMessage());
            return new ResponseEntity<>("There was an error on the server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @GetMapping()
    public ResponseEntity<?> list(HttpServletRequest request) {
        try {
            return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
        } catch (Exception ex) {
            log.error("There was an error: {}", ex.getMessage());
            return new ResponseEntity<>("There was an error on the server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<?> getById(HttpServletRequest request, @PathVariable KeyType id) {
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        } catch (Exception ex) {
            log.error("There was an error: {}", ex.getMessage());
            return new ResponseEntity<>("There was an error on the server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PatchMapping("{id}")
    public ResponseEntity<?> delete(HttpServletRequest request, @PathVariable KeyType id) {
        try {
            Entity entity = service.getById(id);
            service.delete(entity);
            return new ResponseEntity<>("Entity deleted successfully", HttpStatus.OK);
        } catch (Exception ex) {
            log.error("There was an error: {}", ex.getMessage());
            return new ResponseEntity<>("There was an error on the server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
