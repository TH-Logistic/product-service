package com.thlogistic.product.client.job;

import com.thlogistic.product.adapters.dtos.BaseResponse;
import com.thlogistic.product.client.auth.PermissionDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface JobClient {
    @RequestLine("GET api/v1/job/statistic/product/{productId}")
    @Headers({
            "Content-Type: application/json",
            "Authorization: {token}"
    })
    BaseResponse<GetJobStatisticResponse> getJobStatistic(@Param("token") String token, @Param("productId") String productId);
}
