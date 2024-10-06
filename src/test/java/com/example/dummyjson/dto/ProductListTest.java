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

        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("A dummy title");
        product1.setDescription("A dummy description");
        product1.setPrice(Double.valueOf("2.1"));

        ProductList productList = new ProductList();
        productList.setProducts(new ArrayList<>());
        productList.getProducts().add(product1);

        assertEquals(expectId, productList.getProducts().get(0).getId());
        assertEquals(expectedTitle, productList.getProducts().get(0).getTitle());
        assertEquals(expectedDescription, productList.getProducts().get(0).getDescription());
        assertEquals(expectedPrice, productList.getProducts().get(0).getPrice());
    }
}
