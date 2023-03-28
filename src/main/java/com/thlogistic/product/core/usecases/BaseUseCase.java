package com.thlogistic.product.core.usecases;

public interface BaseUseCase<Request, Response> {
    Response execute(Request request);
}
