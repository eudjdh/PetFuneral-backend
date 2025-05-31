package com.tomfrank.PetFuneral.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class BuyRequest {
    @NotNull private int productId;
}
