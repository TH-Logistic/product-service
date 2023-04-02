package com.thlogistic.product.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductResponse {
    String id;
    String name;
    String unit;
    List<Integer> types;
    Double basePrice;
}
