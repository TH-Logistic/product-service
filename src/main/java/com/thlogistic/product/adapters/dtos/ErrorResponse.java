package com.thlogistic.product.adapters.dtos;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {

    public static Map<String, Object> errorResponse(String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", message);
        response.put("data", data);
        return response;
    }
}
