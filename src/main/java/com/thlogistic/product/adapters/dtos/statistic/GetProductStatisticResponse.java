package com.thlogistic.product.adapters.dtos.statistic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductStatisticResponse {
    Integer total;
    List<GetProductTypeWithCountItemDto> products;
}
