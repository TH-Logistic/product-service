package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.BasePagingResponse;
import com.thlogistic.product.adapters.dtos.GetProductResponse;
import com.thlogistic.product.adapters.dtos.ListProductPagingRequest;
import com.thlogistic.product.adapters.dtos.UpdateProductRequest;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListProductUseCase extends BaseUseCase<ListProductPagingRequest, BasePagingResponse<GetProductResponse>> {
}
