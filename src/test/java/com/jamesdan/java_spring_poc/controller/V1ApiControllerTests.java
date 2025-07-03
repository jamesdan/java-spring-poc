package com.jamesdan.java_spring_poc.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(V1ApiController.class)
class V1ApiControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Post endpoint should return greeting with provided name")
    void postEndpointReturnsGreetingWithName() throws Exception {
        mockMvc.perform(post("/v1").param("name", "John")).andExpect(status().isOk()).andExpect(content().string("Hello John! Welcoming you in Java Spring POC"));
    }

    @Test
    @DisplayName("Post endpoint should return bad request when name is missing")
    void postEndpointReturnsBadRequestWhenNameIsMissing() throws Exception {
        mockMvc.perform(post("/v1")).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Get endpoint should return static greeting message")
    void getEndpointReturnsStaticGreeting() throws Exception {
        mockMvc.perform(get("/v1")).andExpect(status().isOk()).andExpect(content().string("Hello from Java Spring POC v1 API"));
    }

    @Test
    @DisplayName("Put endpoint should return update message with provided name")
    void putEndpointReturnsUpdateMessageWithName() throws Exception {
        mockMvc.perform(put("/v1").param("name", "Alice")).andExpect(status().isOk()).andExpect(content().string("Hello Alice! You have been updated in Java Spring POC"));
    }

    @Test
    @DisplayName("Put endpoint should return bad request when name is missing")
    void putEndpointReturnsBadRequestWhenNameIsMissing() throws Exception {
        mockMvc.perform(put("/v1")).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Delete endpoint should return removal message with provided name")
    void deleteEndpointReturnsRemovalMessageWithName() throws Exception {
        mockMvc.perform(delete("/v1").param("name", "Bob")).andExpect(status().isOk()).andExpect(content().string("Goodbye Bob! You have been removed from Java Spring POC"));
    }

    @Test
    @DisplayName("Delete endpoint should return bad request when name is missing")
    void deleteEndpointReturnsBadRequestWhenNameIsMissing() throws Exception {
        mockMvc.perform(delete("/v1")).andExpect(status().isBadRequest());
    }
}