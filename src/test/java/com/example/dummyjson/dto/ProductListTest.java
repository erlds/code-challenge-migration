package com.example.dummyjson.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductListTest {

    @Test
    public void testProductList(){
        Long expectId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        Double expectedPrice = Double.valueOf("2.1");

        Product product1 = new Product(1L, "A dummy title", "A dummy description", Double.valueOf("2.1"));

        ProductList productList = new ProductList(new ArrayList<>());
        productList.products().add(product1);

        assertEquals(expectId, productList.products().get(0).id());
        assertEquals(expectedTitle, productList.products().get(0).title());
        assertEquals(expectedDescription, productList.products().get(0).description());
        assertEquals(expectedPrice, productList.products().get(0).price());
    }
}
