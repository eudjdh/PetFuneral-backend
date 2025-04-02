package com.tomfrank.PetFuneral.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userID;
    private String nickName;
    private String password;
    private String realName;
    private String phone;
    private String email;
    private String address;
}
