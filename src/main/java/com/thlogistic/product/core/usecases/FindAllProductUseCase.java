package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.GetFindAllProductRequest;
import com.thlogistic.product.adapters.dtos.GetProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FindAllProductUseCase extends BaseUseCase<GetFindAllProductRequest, List<GetProductResponse>> {
}
