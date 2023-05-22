package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.BaseTokenRequest;
import com.thlogistic.product.adapters.dtos.GetProductDetailResponse;
import com.thlogistic.product.adapters.dtos.GetProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface GetProductDetailUseCase extends BaseUseCase<BaseTokenRequest<String>, GetProductDetailResponse> {
}
