package com.tuandang.ecommerce_api.api.dto.request.addresses;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record AddressDtoRequest(
        UUID userId,
        String province,
        String district,
        String ward,
        String city,
        String county,
        @NotEmpty
        String specificAddress,
        boolean isDefault,
        String type,
        @NotEmpty
        String phoneNumber
) {
}
