package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private Long id;

    @BeforeEach
    public void setUp() {
        id = 1L;
    }

    @Test
    public void testGetAllProducts() {
        int index = (int) (id - 1);

        List<Product> result = productService.getAllProducts();

        Assertions.assertTrue(result.size() > 0);
        Assertions.assertEquals(result.get(index).getId(),id);
    }

    @Test
    public void testGetProductById() {
        Product result = productService.getProductById(id);
        Assertions.assertEquals(id, result.getId());
    }
}
