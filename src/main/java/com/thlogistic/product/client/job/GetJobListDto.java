package com.thlogistic.product.client.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetJobListDto {
    String id;
    String licensePlate;
    String driverInCharge;
    String createdAt;
    String pickUpAt;
    String unloadAt;
    Double orderFee;
    Integer status;
}
