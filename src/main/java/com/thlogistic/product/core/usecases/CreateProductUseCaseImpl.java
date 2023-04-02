package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.CreateProductRequest;
import com.thlogistic.product.adapters.dtos.CreateProductResponse;
import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import com.thlogistic.product.core.entities.ProductType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepository repository;

    @Override
    public CreateProductResponse execute(CreateProductRequest createProductRequest) {
        ProductEntity entity = new ProductEntity(
                createProductRequest.getName(),
                createProductRequest.getUnit(),
                createProductRequest.getTypes().stream().map(ProductType::fromInt).toList(),
                createProductRequest.getBasePrice()
        );
        String id = repository.insert(entity);
        return new CreateProductResponse(id);
    }
}
