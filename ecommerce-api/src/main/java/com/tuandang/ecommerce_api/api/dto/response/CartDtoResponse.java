package com.tuandang.ecommerce_api.api.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CartDtoResponse(
    UUID id,
    Float totalCost
) {
}
