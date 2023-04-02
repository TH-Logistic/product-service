package com.thlogistic.product.adapters.repositories;

import com.thlogistic.product.core.entities.ProductType;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoProductRepository extends MongoRepository<ProductEntity, String> {
    Page<ProductEntity> findByBasePriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

    Page<ProductEntity> findByBasePriceBetweenAndTypesIs(Double minPrice, Double maxPrice, List<ProductType> types, Pageable pageable);
}
