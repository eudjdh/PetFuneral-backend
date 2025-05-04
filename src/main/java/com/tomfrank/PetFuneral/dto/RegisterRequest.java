package com.tomfrank.PetFuneral.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class RegisterRequest {
    @NotBlank @Size(min=3, max=50)
    private String username;

    @NotBlank @Size(min=6, max=20)
    private String password;

    @NotBlank @Pattern(regexp="^\\d{10,15}$")
    private String phone;

    private String email;
    private String address;
}
