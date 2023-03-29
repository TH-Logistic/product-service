package com.thlogistic.product.adapters.controllers;

import com.thlogistic.product.adapters.dtos.CreateProductRequest;
import com.thlogistic.product.adapters.dtos.CreateProductResponse;
import com.thlogistic.product.adapters.dtos.UpdateProductRequest;
import com.thlogistic.product.core.usecases.CreateProductUseCase;
import com.thlogistic.product.core.usecases.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController extends BaseController implements ProductResource {
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;

    @Override
    public ResponseEntity<Object> createProduct(CreateProductRequest request) {
        CreateProductResponse result = createProductUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> updateProduct(UpdateProductRequest request, String id) {
        updateProductUseCase.execute(Pair.of(id, request));
        return successResponse(null, null);
    }
}
