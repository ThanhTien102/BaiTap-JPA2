package com.java14.Jpa2.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String name;
    private BigDecimal price;
    private String description;
}
