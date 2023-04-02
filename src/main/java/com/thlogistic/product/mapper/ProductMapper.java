package com.thlogistic.product.mapper;

import com.thlogistic.product.adapters.dtos.GetProductResponse;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;

public class ProductMapper {
    public static GetProductResponse fromProductEntityToResponse(ProductEntity entity) {
        GetProductResponse response = new GetProductResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setUnit(entity.getUnit());
        response.setType(entity.getType().typeCode);
        response.setBasePrice(entity.getBasePrice());
        return response;
    }
}
