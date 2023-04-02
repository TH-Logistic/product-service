package com.thlogistic.product.adapters.dtos;

import com.thlogistic.product.core.entities.ProductType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    @NotBlank(message = "Invalid name")
    String name;
    @NotBlank(message = "Invalid unit")
    String unit;
    @NotNull(message = "Invalid type")
    @Min(value = ProductType.MIN_VALUE, message = "Invalid type")
    @Max(value = ProductType.MAX_VALUE, message = "Invalid type")
    Integer type;
    @DecimalMin(value = "0.0", message = "Invalid base price")
    Double basePrice;
}
