package com.thlogistic.product.core.ports;

import com.thlogistic.product.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    String insert(ProductEntity product);

    String save(ProductEntity product);

    Optional<ProductEntity> findById(String id);
    List<ProductEntity> findAll();

    BasePagingQueryResult<List<ProductEntity>> list(Double minPrice, Double maxPrice, List<Integer> types, Integer page, Integer size);
}
