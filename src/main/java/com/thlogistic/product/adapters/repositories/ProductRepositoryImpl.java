package com.thlogistic.product.adapters.repositories;

import com.thlogistic.product.core.entities.ProductType;
import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final MongoProductRepository repository;

    @Override
    public String insert(ProductEntity product) {
        return repository.insert(product).getId();
    }

    @Override
    public String save(ProductEntity product) {
        return repository.save(product).getId();
    }

    @Override
    public Optional<ProductEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public BasePagingQueryResult<List<ProductEntity>> list(Double minPrice, Double maxPrice, List<Integer> types, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        if (maxPrice == null) {
            maxPrice = Double.MAX_VALUE;
        }
        Page<ProductEntity> products;
        if (types == null || types.isEmpty()) {
            products = repository.findAllByBasePriceBetween(minPrice, maxPrice, pageable);
        } else {
            List<ProductType> typeList = types.stream().map(ProductType::fromInt).toList();
            products = repository.findAllByBasePriceBetweenAndTypesIs(minPrice, maxPrice, typeList, pageable);
        }

        BasePagingQueryResult<List<ProductEntity>> result = new BasePagingQueryResult<>();
        result.data = products.getContent();
        result.total = products.getTotalElements();
        result.totalPage = products.getTotalPages();
        return result;
    }


}
