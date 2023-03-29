package com.thlogistic.product.aop.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String modelName) {
        super(String.format("Cannot find %s", modelName));
    }
}
