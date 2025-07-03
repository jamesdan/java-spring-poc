package com.jamesdan.java_spring_poc.controller;

import com.jamesdan.java_spring_poc.service.CRUDService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(V1ApiController.class)
class V1ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CRUDService crudService;

    @Test
    @DisplayName("Post endpoint should return value from CRUDService.create")
    void postEndpointReturnsCrudServiceCreate() throws Exception {
        when(crudService.create("John")).thenReturn("Created John");
        mockMvc.perform(post("/v1").param("name", "John")).andExpect(status().isOk()).andExpect(content().string("Created John"));
    }

    @Test
    @DisplayName("Post endpoint should return bad request when name is missing")
    void postEndpointReturnsBadRequestWhenNameIsMissing() throws Exception {
        mockMvc.perform(post("/v1")).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Get endpoint should return value from CRUDService.read")
    void getEndpointReturnsCrudServiceRead() throws Exception {
        when(crudService.read()).thenReturn("Read result");
        mockMvc.perform(get("/v1")).andExpect(status().isOk()).andExpect(content().string("Read result"));
    }

    @Test
    @DisplayName("Put endpoint should return value from CRUDService.update")
    void putEndpointReturnsCrudServiceUpdate() throws Exception {
        when(crudService.update("Alice")).thenReturn("Updated Alice");
        mockMvc.perform(put("/v1").param("name", "Alice")).andExpect(status().isOk()).andExpect(content().string("Updated Alice"));
    }

    @Test
    @DisplayName("Put endpoint should return bad request when name is missing")
    void putEndpointReturnsBadRequestWhenNameIsMissing() throws Exception {
        mockMvc.perform(put("/v1")).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Delete endpoint should return value from CRUDService.delete")
    void deleteEndpointReturnsCrudServiceDelete() throws Exception {
        when(crudService.delete("Bob")).thenReturn("Deleted Bob");
        mockMvc.perform(delete("/v1").param("name", "Bob")).andExpect(status().isOk()).andExpect(content().string("Deleted Bob"));
    }

    @Test
    @DisplayName("Delete endpoint should return bad request when name is missing")
    void deleteEndpointReturnsBadRequestWhenNameIsMissing() throws Exception {
        mockMvc.perform(delete("/v1")).andExpect(status().isBadRequest());
    }
}