package com.tomfrank.PetFuneral.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Data
public class BuyRequest {
    @NotNull private int productId;
    @NotNull private Integer quantity;
    @NotNull private BigDecimal priceAtPurchase;
    private Integer userId;
}
