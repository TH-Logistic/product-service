package com.thlogistic.product.core.entities;

import com.thlogistic.product.aop.exception.InvalidProductTypeException;

public enum ProductType {
    DANGEROUS(1),
    FRAGILE(2),
    MACHINE(3),
    ELECTRONIC(4),
    AGRICULTURAL(5),
    FOOD(6),
    COSMETIC(7),
    MEDICINE(8),
    OTHERS(9);

    public final Integer typeCode;

    ProductType(Integer code) {
        typeCode = code;
    }

    public static ProductType fromInt(Integer value) {
        for (ProductType type: values()) {
            if (type.typeCode.equals(value)) {
                return type;
            }
        }
        throw new InvalidProductTypeException("Product type not found");
    }

}
