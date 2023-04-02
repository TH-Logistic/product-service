package com.thlogistic.product.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    String id;
    String name;
    String unit;
    ProductType type;
    Double basePrice;


}
