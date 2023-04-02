package com.thlogistic.product.adapters.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ListProductPagingRequest extends BasePagingRequest {

    @DecimalMin(value = "0.0", message = "Invalid min price")
    Double minPrice;

    @DecimalMin(value = "0.0", message = "Invalid max price")
    Double maxPrice;
    Integer type;
}
