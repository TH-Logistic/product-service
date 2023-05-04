package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.GetProductResponse;
import com.thlogistic.product.adapters.dtos.UpdateProductRequest;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
public interface GetProductUseCase extends BaseUseCase<String, GetProductResponse> {
}
