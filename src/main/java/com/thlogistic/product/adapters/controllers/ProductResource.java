package com.thlogistic.product.adapters.controllers;

import com.thlogistic.product.adapters.dtos.CreateProductRequest;
import com.thlogistic.product.adapters.dtos.UpdateProductRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
interface ProductResource {

    @PostMapping
    ResponseEntity<Object> createProduct(@Valid @RequestBody CreateProductRequest request);

    @PutMapping("/{id}")
    ResponseEntity<Object> updateProduct(@Valid @RequestBody UpdateProductRequest request, @PathVariable String id);
}
