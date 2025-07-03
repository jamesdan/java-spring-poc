package com.jamesdan.java_spring_poc.controller;

import com.jamesdan.java_spring_poc.service.CRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class V1ApiController {
    private final CRUDService crudService;
    @PostMapping
    public String postV1Api(@RequestParam String name, @RequestParam int age) {
        return crudService.create(name, age);
    }

    @GetMapping
    public String getV1Api(@RequestParam Long id) {
        return crudService.read(id);
    }

    @PutMapping
    public String putV1Api(@RequestParam String name, @RequestParam int age) {
        return crudService.update(name, age);
    }

    @DeleteMapping
    public String deleteV1Api(@RequestParam String name) {
        return crudService.delete(name);
    }

}
