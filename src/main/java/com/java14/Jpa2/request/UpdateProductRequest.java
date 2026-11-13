package com.java14.Jpa2.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class UpdateProductRequest {
    private int id;
    private String name;
    private BigDecimal price;
    private String description;
}
