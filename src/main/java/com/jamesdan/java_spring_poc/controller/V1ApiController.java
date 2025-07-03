package com.jamesdan.java_spring_poc.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class V1ApiController {
    @PostMapping
    public String postV1Api(@RequestParam String name) {
        return "Hello "+name+"! Welcoming you in Java Spring POC";
    }

    @GetMapping
    public String getV1Api() {
        return "Hello from Java Spring POC v1 API";
    }

    @PutMapping
    public String putV1Api(@RequestParam String name) {
        return "Hello "+name+"! You have been updated in Java Spring POC";
    }

    @DeleteMapping
    public String deleteV1Api(@RequestParam String name) {
        return "Goodbye "+name+"! You have been removed from Java Spring POC";
    }

}
