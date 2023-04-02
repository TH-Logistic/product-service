package com.thlogistic.product.adapters.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    @NotBlank(message = "Invalid name")
    String name;
    @NotBlank(message = "Invalid unit")
    String unit;
    @NotNull(message = "Invalid types")
    @NotEmpty(message = "Invalid types")
    List<Integer> types;
    @DecimalMin(value = "0.0", message = "Invalid base price")
    Double basePrice;
}
