package com.tomfrank.PetFuneral.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class RegisterRequest {
    @NotBlank private String username;

    @NotBlank @Size(min=6, max=20)
    private String password;

    @NotBlank private String phone;

    private String email;
    private String address;
}
