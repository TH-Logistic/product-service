package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.*;
import com.thlogistic.product.adapters.repositories.BasePagingQueryResult;
import com.thlogistic.product.core.entities.ProductType;
import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import com.thlogistic.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListProductUseCaseImpl implements ListProductUseCase {

    private final ProductRepository repository;

    @Override
    public BasePagingResponse<GetProductResponse> execute(ListProductPagingRequest request) {
        BasePagingQueryResult<List<ProductEntity>> queryResult =
                repository.list(request.getMinPrice(), request.getMaxPrice(), request.getType(), request.getPage(), request.getSize());

        BasePagingResponse<GetProductResponse> response = new BasePagingResponse<>();
        response.setContent(queryResult.getData().stream().map(ProductMapper::fromProductEntityToResponse).toList());
        response.setTotal(queryResult.getTotal());
        response.setTotalPage(queryResult.getTotalPage());
        return response;
    }
}
