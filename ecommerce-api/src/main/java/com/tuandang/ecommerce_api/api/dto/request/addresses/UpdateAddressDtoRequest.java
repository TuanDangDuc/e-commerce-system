package com.tuandang.ecommerce_api.api.dto.request.addresses;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record UpdateAddressDtoRequest(
        UUID id,
        UUID userId,
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
