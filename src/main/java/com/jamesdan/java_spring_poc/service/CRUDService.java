package com.jamesdan.java_spring_poc.service;

import org.springframework.stereotype.Service;

@Service
public class CRUDService {
    public String create(String name) {
        return "Hello " + name + "! Welcoming you in Java Spring POC by CRUDService";
    }

    public String read() {
        return "Hello from Java Spring POC by CRUDService";
    }

    public String update(String name) {
        return "Hello " + name + "! You have been updated in Java Spring POC by CRUDService";
    }

    public String delete(String name) {
        return "Goodbye " + name + "! You have been removed from Java Spring POC by CRUDService";
    }
}
