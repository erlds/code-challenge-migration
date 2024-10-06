package com.example.dummyjson.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    private static final String URI = "/api/products";

    @Autowired
    private MockMvc mvc;

    private int id;

    @BeforeEach
    public void setUp() {
        id = 1;
    }

    @Test
    public void testGetAllProducts() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URI))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", Matchers.is(id)));
    }

    @Test
    public void testGetProductById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URI + "/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", Matchers.is(id)));
    }
}
