package com.tomfrank.PetFuneral.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderService {
    @TableId("order_service_id")
    private Integer orderServiceId;
    private String receiveTime;
    private String receiveAdd;
    private String receiveCarType;
    private String mourningRoomType;
    private int userId;
}
