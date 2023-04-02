package com.thlogistic.product.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    String id;
    String name;
    String unit;
    List<ProductType> types;
    Double basePrice;


}
