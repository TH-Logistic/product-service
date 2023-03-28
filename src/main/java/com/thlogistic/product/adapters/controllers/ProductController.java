package com.thlogistic.product.adapters.controllers;

import com.thlogistic.product.adapters.dtos.CreateProductRequest;
import com.thlogistic.product.adapters.dtos.CreateProductResponse;
import com.thlogistic.product.core.usecases.CreateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductResource {
    private final CreateProductUseCase createProductUseCase;

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {
        return createProductUseCase.execute(request);
    }
}
