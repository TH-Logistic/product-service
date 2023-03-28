package com.thlogistic.product.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    String name;
    String unit;
    Integer type;
    Double basePrice;
}
