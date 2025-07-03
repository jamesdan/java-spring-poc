package com.jamesdan.java_spring_poc.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CRUDServiceTest {

    private final CRUDService crudService = new CRUDService();

    @Test
    @DisplayName("Create method should return a welcome message with the provided name")
    void createReturnsWelcomeMessage() {
        String result = crudService.create("John");
        assertThat(result).isEqualTo("Hello John! Welcoming you in Java Spring POC by CRUDService");
    }

    @Test
    @DisplayName("Read method should return a generic welcome message")
    void readReturnsGenericWelcomeMessage() {
        String result = crudService.read();
        assertThat(result).isEqualTo("Hello from Java Spring POC by CRUDService");
    }

    @Test
    @DisplayName("Update method should return an update message with the provided name")
    void updateReturnsUpdateMessage() {
        String result = crudService.update("Alice");
        assertThat(result).isEqualTo("Hello Alice! You have been updated in Java Spring POC by CRUDService");
    }

    @Test
    @DisplayName("Delete method should return a goodbye message with the provided name")
    void deleteReturnsGoodbyeMessage() {
        String result = crudService.delete("Bob");
    }
}