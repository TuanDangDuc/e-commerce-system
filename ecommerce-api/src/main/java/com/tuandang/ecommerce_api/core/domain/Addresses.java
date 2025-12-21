package com.tuandang.ecommerce_api.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class Addresses {
    private UUID id;
    private UUID userId;
    private String province;
    private String district;
    private String ward;
    private String city;
    private String county;
    private String specificAddress;
    private boolean isDefault;
    private String type;
    private String phoneNumber;

}
