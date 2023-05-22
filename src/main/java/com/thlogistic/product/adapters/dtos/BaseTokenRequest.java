package com.thlogistic.product.adapters.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseTokenRequest<T> {
    String token;
    T requestContent;
}
