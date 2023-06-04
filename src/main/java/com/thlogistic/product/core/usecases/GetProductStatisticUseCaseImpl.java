package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.statistic.GetProductStatisticResponse;
import com.thlogistic.product.adapters.dtos.statistic.GetProductTypeWithCountItemDto;
import com.thlogistic.product.core.entities.ProductType;
import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetProductStatisticUseCaseImpl implements GetProductStatisticUseCase {

    private final ProductRepository productRepository;

    @Override
    public GetProductStatisticResponse execute() {
        GetProductStatisticResponse response = new GetProductStatisticResponse();
        List<ProductEntity> entities = productRepository.findAll();

        Map<Integer, Integer> productByTypeMap = new LinkedHashMap<>();

        Integer[] types = {
                ProductType.DANGEROUS.typeCode,
                ProductType.FRAGILE.typeCode,
                ProductType.MACHINE.typeCode,
                ProductType.ELECTRONIC.typeCode,
                ProductType.AGRICULTURAL.typeCode,
                ProductType.FOOD.typeCode,
                ProductType.COSMETIC.typeCode,
                ProductType.MEDICINE.typeCode,
                ProductType.OTHERS.typeCode,
        };

        for (Integer type : types) {
            productByTypeMap.put(type, 0);
        }

        for (ProductEntity entity : entities) {
            List<Integer> productTypes = entity.getTypes().stream().map(it -> it.typeCode).toList();
            for (Integer type : productTypes) {
                Integer currentTotal = productByTypeMap.get(type);
                productByTypeMap.put(type, currentTotal + 1);
            }
        }

        List<GetProductTypeWithCountItemDto> products = new LinkedList<>();
        productByTypeMap.forEach((type, total) -> products.add(
                new GetProductTypeWithCountItemDto(type, total)
        ));

        return new GetProductStatisticResponse(
                entities.size(),
                products
        );
    }
}
