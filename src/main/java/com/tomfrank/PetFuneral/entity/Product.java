package com.tomfrank.PetFuneral.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @TableId("product_id")
    private Integer productId;
    private String name;
    private String type;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private String imageUrl;
}
