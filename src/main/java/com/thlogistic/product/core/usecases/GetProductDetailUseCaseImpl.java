package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.BaseResponse;
import com.thlogistic.product.adapters.dtos.BaseTokenRequest;
import com.thlogistic.product.adapters.dtos.GetProductDetailResponse;
import com.thlogistic.product.adapters.dtos.GetProductResponse;
import com.thlogistic.product.aop.exception.CustomRuntimeException;
import com.thlogistic.product.aop.exception.DataNotFoundException;
import com.thlogistic.product.client.job.GetJobListDto;
import com.thlogistic.product.client.job.GetJobStatisticResponse;
import com.thlogistic.product.client.job.JobClient;
import com.thlogistic.product.client.job.JobStatisticDto;
import com.thlogistic.product.core.entities.Product;
import com.thlogistic.product.core.ports.ProductRepository;
import com.thlogistic.product.infrastructure.persistence.entities.ProductEntity;
import com.thlogistic.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductDetailUseCaseImpl implements GetProductDetailUseCase {

    private final GetProductUseCase getProductUseCase;
    private final JobClient jobClient;

    @Override
    public GetProductDetailResponse execute(BaseTokenRequest<String> baseTokenRequest) {
        String token = baseTokenRequest.getToken();
        String productId = baseTokenRequest.getRequestContent();

        GetProductResponse productDto = getProductUseCase.execute(productId);

        BaseResponse<GetJobStatisticResponse> getJobStatisticResponse;
        try {
            getJobStatisticResponse = jobClient.getJobStatistic(token, productId);
        } catch (Exception e) {
            throw new CustomRuntimeException("An error occurred when loading statistic for product detail");
        }

        JobStatisticDto jobStatisticDto = getJobStatisticResponse.getData().getStatistic();
        List<GetJobListDto> jobListDtos = getJobStatisticResponse.getData().getJobs();

        return new GetProductDetailResponse(
                productDto,
                jobStatisticDto,
                jobListDtos
        );
    }
}
