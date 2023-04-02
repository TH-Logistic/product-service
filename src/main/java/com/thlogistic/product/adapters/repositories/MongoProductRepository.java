package com.thlogistic.product.adapters.repositories;

import com.thlogistic.product.core.entities.ProductType;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoProductRepository extends MongoRepository<ProductEntity, String> {
    Page<ProductEntity> findByBasePriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

    Page<ProductEntity> findByBasePriceBetweenAndTypeIs(Double basePrice, Double basePrice2, ProductType type, Pageable pageable);
}
