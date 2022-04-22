package com.test.telefonica.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface BaseController<Entity, KeyType> {
    @PostMapping("paginate")
    ResponseEntity<?> paginate(@RequestParam(defaultValue = "0") Integer page,
                               @RequestParam(defaultValue = "10") Integer size);

    @GetMapping()
    ResponseEntity<?> list(HttpServletRequest request);

    @GetMapping("{id")
    ResponseEntity<?> getById(@PathVariable KeyType id);

    @GetMapping("{id")
    ResponseEntity<?> delete(@PathVariable KeyType id);
}
