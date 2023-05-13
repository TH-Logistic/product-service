package com.thlogistic.product.adapters.controllers;

import com.thlogistic.product.adapters.dtos.*;
import com.thlogistic.product.core.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController extends BaseController implements ProductResource {
    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final ListProductUseCase listProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final FindAllProductUseCase findAllProductUseCase;

    @Override
    public ResponseEntity<Object> getProduct(String id) {
        GetProductResponse response = getProductUseCase.execute(id);
        return successResponse(response, null);
    }

    @Override
    public ResponseEntity<Object> listProduct(ListProductPagingRequest request) {
        BasePagingResponse<GetProductResponse> result = listProductUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> findProducts(GetFindAllProductRequest request) {
        List<GetProductResponse> result = findAllProductUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> createProduct(CreateProductRequest request) {
        CreateProductResponse result = createProductUseCase.execute(request);
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> updateProduct(UpdateProductRequest request, String id) {
        updateProductUseCase.execute(Pair.of(id, request));
        return successResponse(true, null);
    }
}
