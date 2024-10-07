package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    @Value("${dummyjson.baseUrl}")
    private String baseUrl;

    private final WebClient webClient;

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .defaultHeader("Accept", "application/json")
                .build();
    }

    public List<Product> getAllProducts() {
        ProductList productList = webClient.get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(ProductList.class)
                .doOnError(error -> System.out.println("Error occurred: " + error.getMessage())).block();
        return productList != null ? productList.products() : List.of();
    }

    public Product getProductById(Long id) {
        String url = baseUrl + "/" + id;
        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .bodyToMono(Product.class)
                .doOnError(error -> System.out.println("Error occurred: " + error.getMessage())).block();
    }
}