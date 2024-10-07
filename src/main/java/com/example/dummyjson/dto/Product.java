package com.example.dummyjson.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record Product(
        @NotNull @Min(0L) @Max(999L)Long id,
        @NotNull String title,
        @NotNull String description,
        @NotNull Double price
){}
