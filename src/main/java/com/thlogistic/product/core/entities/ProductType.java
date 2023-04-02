package com.thlogistic.product.core.entities;

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

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    ProductType(Integer code) {
        typeCode = code;
    }

    public static ProductType fromInt(Integer value) {
        for (ProductType type: values()) {
            if (type.typeCode.equals(value)) {
                return type;
            }
        }
        return null;
    }

}
