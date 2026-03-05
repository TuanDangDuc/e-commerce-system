package com.tuandang.ecommerce_api.api.dto.response;

import lombok.Builder;

import java.util.UUID;


@Builder
public record AddressesDtoResponse(
        UUID id,
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
