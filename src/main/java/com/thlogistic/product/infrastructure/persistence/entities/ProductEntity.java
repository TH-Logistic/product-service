package com.thlogistic.product.infrastructure.persistence.entities;

import com.thlogistic.product.core.entities.Product;
import com.thlogistic.product.core.entities.ProductType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document("product")
public class ProductEntity {
    @Id
    String id;
    String name;
    String unit;
    List<ProductType> types;
    Double basePrice;

    public ProductEntity(String name, String unit, List<ProductType> types, Double basePrice) {
        this.name = name;
        this.unit = unit;
        this.types = types;
        this.basePrice = basePrice;
    }

    public Product toProduct() {
        return new Product(
                this.id,
                this.name,
                this.unit,
                this.types,
                this.basePrice
        );
    }
}
