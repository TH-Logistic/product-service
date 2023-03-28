package com.thlogistic.product.infrastructure.persistence.entities;

public enum ProductType {
    DANGEROUS(1),
    MACHINE(2),
    ELECTRONIC(3),
    USE_IN_AGRICULTURE(4),
    FOOD(5),
    COSMETIC(6),
    MEDICINE(7),
    FRAGILE(8),
    OTHERS(9);

    public final Integer typeCode;

    ProductType(Integer code) {
        typeCode = code;
    }

    public static ProductType fromInt(Integer value) {
        for (ProductType status: values()) {
            if (status.typeCode.equals(value)) {
                return status;
            }
        }
        return null;
    }

}
