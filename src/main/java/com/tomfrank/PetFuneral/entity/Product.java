package com.tomfrank.PetFuneral.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer productID;
    private String name;
    private String type;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private String imageURL;
}
