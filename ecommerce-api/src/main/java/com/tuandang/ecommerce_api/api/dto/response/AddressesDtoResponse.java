package com.tuandang.ecommerce_api.api.dto.response;

import lombok.Builder;


@Builder
public record AddressesDtoResponse(
        String province,
        String district,
        String ward,
        String city,
        String county,
        String specificAddress,
        Boolean isDefault,
        String type,
        String phoneNumber
) {
}
