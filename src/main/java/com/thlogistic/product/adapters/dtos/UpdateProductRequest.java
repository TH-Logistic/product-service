package com.thlogistic.product.adapters.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
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
