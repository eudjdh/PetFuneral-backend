package com.tomfrank.PetFuneral.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOrder {
    private Integer serviceOrderID;
    private Integer orderID;
    private Integer petID;
    private LocalDateTime receiveTime;
    private String receiveAddress;
    private LocalDateTime mourningRoomTime;
    private String mourningRoomType;
    private String mourningRoomLocation;
    private BigDecimal totalServicePrice;
    private String notes;
}
