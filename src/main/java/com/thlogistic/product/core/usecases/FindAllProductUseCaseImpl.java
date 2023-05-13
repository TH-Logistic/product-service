package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.GetFindAllProductRequest;
import com.thlogistic.product.adapters.dtos.GetProductResponse;
import com.thlogistic.product.aop.exception.DataNotFoundException;
import com.thlogistic.product.core.entities.Product;
import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import com.thlogistic.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindAllProductUseCaseImpl implements FindAllProductUseCase {

    private final GetProductUseCase getProductUseCase;

    @Override
    public List<GetProductResponse> execute(GetFindAllProductRequest request) {
        List<GetProductResponse> response = new LinkedList<>();
        if (!request.getIds().isEmpty()) {
            request.getIds().forEach(id -> {
                GetProductResponse productResponse = getProductUseCase.execute(id);
                response.add(productResponse);
            });
        }
        return response;
    }
}
