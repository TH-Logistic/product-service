package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.CreateProductRequest;
import com.thlogistic.product.adapters.dtos.CreateProductResponse;
import com.thlogistic.product.adapters.dtos.UpdateProductRequest;
import com.thlogistic.product.aop.exception.DataNotFoundException;
import com.thlogistic.product.core.entities.Product;
import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import com.thlogistic.product.infrastructure.persistence.entities.ProductType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductRepository repository;

    @Override
    public Object execute(Pair<String, UpdateProductRequest> requestPair) {
        Optional<ProductEntity> entity = repository.findById(requestPair.getFirst());
        if (entity.isEmpty()) {
            throw new DataNotFoundException(Product.class.getSimpleName());
        }
        UpdateProductRequest request = requestPair.getSecond();
        ProductEntity result = entity.get();
        result.setName(request.getName());
        result.setUnit(request.getUnit());
        result.setType(ProductType.fromInt(request.getType()));
        result.setBasePrice(request.getBasePrice());
        repository.save(result);
        return null;
    }
}
