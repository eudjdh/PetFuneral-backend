package com.tomfrank.PetFuneral.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer orderID;
    private Integer userID;
    private String orderType;
    private BigDecimal totalPrice;
    private String status;
}
