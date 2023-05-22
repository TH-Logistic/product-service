package com.thlogistic.product.adapters.dtos;

import com.thlogistic.product.client.job.GetJobListDto;
import com.thlogistic.product.client.job.GetJobStatisticResponse;
import com.thlogistic.product.client.job.JobStatisticDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductDetailResponse {
    GetProductResponse product;
    JobStatisticDto statistic;
    List<GetJobListDto> jobs;
}
