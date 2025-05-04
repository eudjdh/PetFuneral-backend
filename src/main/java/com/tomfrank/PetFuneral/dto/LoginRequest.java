package com.tomfrank.PetFuneral.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class LoginRequest {
    @NotBlank private String username;
    @NotBlank private String password;
}
