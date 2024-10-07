package com.example.dummyjson.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    public void testProduct(){
        Long expectId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        Double expectedPrice = Double.valueOf("2.1");

        Product product1 = new Product(1L, "A dummy title", "A dummy description", Double.valueOf("2.1"));

        assertEquals(expectId, product1.id());
        assertEquals(expectedTitle, product1.title());
        assertEquals(expectedDescription, product1.description());
        assertEquals(expectedPrice, product1.price());
    }
}
