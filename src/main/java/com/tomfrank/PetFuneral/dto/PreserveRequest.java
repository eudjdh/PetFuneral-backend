package com.tomfrank.PetFuneral.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class PreserveRequest {
    @NotBlank private String receiveAdd;
    @NotBlank private String receiveTime;
    @NotBlank private String receiveCarType;
    @NotBlank private String mourningRoomType;
    private Integer userId;
}
