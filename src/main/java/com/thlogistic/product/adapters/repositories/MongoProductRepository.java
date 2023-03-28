package com.thlogistic.product.adapters.repositories;

import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MongoProductRepository extends MongoRepository<ProductEntity, String> {
}
