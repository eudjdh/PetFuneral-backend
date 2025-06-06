package com.tomfrank.PetFuneral.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    @TableId("order_product_id")
    private Integer orderProductId;
    private Integer productId;
    private Integer quantity;
    private BigDecimal priceAtPurchase;
    private int userId;
}
