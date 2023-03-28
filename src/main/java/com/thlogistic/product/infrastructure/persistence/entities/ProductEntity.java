package com.thlogistic.product.infrastructure.persistence.entities;

import com.thlogistic.product.core.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("product")
public class ProductEntity {
    @Id
    String id;
    String name;
    String unit;
    ProductType type;
    Double basePrice;

    public ProductEntity(String name, String unit, ProductType type, Double basePrice) {
        this.name = name;
        this.unit = unit;
        this.type = type;
        this.basePrice = basePrice;
    }

    public Product fromThis() {
        return new Product(
                this.id,
                this.name,
                this.unit,
                this.type,
                this.basePrice
        );
    }
}
