package com.example.dummyjson.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WebClientConfigTest {

    @Autowired
    private WebClientConfig webClientConfig;

    @Test
    public void testRestTemplateConfig(){
        Assertions.assertNotNull(this.webClientConfig.webClient());
    }
}
