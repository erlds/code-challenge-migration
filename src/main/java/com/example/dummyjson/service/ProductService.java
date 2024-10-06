package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    private final String BASE_URL = "https://dummyjson.com/products";

    private final WebClient webClient;

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl(BASE_URL)
                .defaultHeader("Accept", "application/json")
                .build();;
    }


    public List<Product> getAllProducts() {
        ProductList productList = webClient.get()
                .retrieve()
                .bodyToMono(ProductList.class)
                .doOnError(error -> System.out.println("Error occurred: " + error.getMessage())).block();
        return productList != null ? productList.getProducts() : List.of();
    }

    public Product getProductById(Long id) {
        String url = "/" + id;
        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .bodyToMono(Product.class)
                .doOnError(error -> System.out.println("Error occurred: " + error.getMessage())).block();
    }
}