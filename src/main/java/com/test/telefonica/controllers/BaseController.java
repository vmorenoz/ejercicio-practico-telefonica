package com.test.telefonica.controllers;

import com.test.telefonica.entities.BaseEntity;
import com.test.telefonica.services.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Log4j2
public class BaseController<Entity extends BaseEntity, KeyType> {

    private final BaseService<Entity, KeyType> service;

    public BaseController(BaseService<Entity, KeyType> service) {
        this.service = service;
    }

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
}
