package com.tomfrank.PetFuneral.dto;

import lombok.Data;

@Data
public class UserProfileVO {
    private Integer userId;
    private String username;
    private String realName;
    private String phone;
    private String email;
    private String address;
}
