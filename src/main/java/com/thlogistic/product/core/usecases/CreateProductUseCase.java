package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.CreateProductRequest;
import com.thlogistic.product.adapters.dtos.CreateProductResponse;
import org.springframework.stereotype.Service;


public interface CreateProductUseCase extends BaseUseCase<CreateProductRequest, CreateProductResponse> {
}
