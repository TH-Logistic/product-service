package com.thlogistic.product.adapters.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ListProductPagingRequest extends BasePagingRequest {

    @Min(value = 0, message = "Invalid min price")
    Double minPrice;

    @Min(value = 0, message = "Invalid max price")
    Double maxPrice;

    List<Integer> types;
}
