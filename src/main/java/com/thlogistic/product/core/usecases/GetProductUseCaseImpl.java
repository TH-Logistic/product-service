package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.GetProductResponse;
import com.thlogistic.product.adapters.dtos.UpdateProductRequest;
import com.thlogistic.product.aop.exception.DataNotFoundException;
import com.thlogistic.product.core.entities.Product;
import com.thlogistic.product.core.entities.ProductType;
import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import com.thlogistic.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductUseCaseImpl implements GetProductUseCase {

    private final ProductRepository repository;

    @Override
    public GetProductResponse execute(String id) {
        Optional<ProductEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new DataNotFoundException(Product.class.getSimpleName());
        }
        return ProductMapper.fromProductEntityToResponse(entity.get());
    }
}
