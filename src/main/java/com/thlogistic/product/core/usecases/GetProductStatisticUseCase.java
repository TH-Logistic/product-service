package com.thlogistic.product.core.usecases;

import com.thlogistic.product.adapters.dtos.statistic.GetProductStatisticResponse;
import org.springframework.stereotype.Service;

@Service
public interface GetProductStatisticUseCase extends BaseUseCaseNoParam<GetProductStatisticResponse> {
}
