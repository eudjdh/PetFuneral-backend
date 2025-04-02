package com.tomfrank.PetFuneral.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    private Integer orderProductID;
    private Integer orderID;
    private Integer productID;
    private Integer quantity;
    private BigDecimal price;
}
