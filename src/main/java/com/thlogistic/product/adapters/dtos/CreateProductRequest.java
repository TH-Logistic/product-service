package com.thlogistic.product.adapters.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateProductRequest {
    @NotBlank(message = "Invalid name")
    String name;
    @NotBlank(message = "Invalid unit")
    String unit;
    @NotNull(message = "Invalid type")
    @Size(min = 1, max = 1, message = "Invalid type")
    Integer type;
    @DecimalMin(value = "0.0", message = "Invalid base price")
    Double basePrice;
}
