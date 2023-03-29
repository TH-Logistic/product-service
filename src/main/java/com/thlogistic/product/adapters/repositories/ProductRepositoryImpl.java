package com.thlogistic.product.adapters.repositories;

import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final MongoProductRepository repository;

    @Override
    public String insert(ProductEntity product) {
        return repository.insert(product).getId();
    }

    @Override
    public String save(ProductEntity product) {
        return repository.save(product).getId();
    }

    @Override
    public Optional<ProductEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }
}
