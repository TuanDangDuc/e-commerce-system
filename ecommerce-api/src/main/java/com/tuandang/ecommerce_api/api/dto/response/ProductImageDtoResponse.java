package com.tuandang.ecommerce_api.api.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Builder
public record ProductImageDtoResponse(
        UUID id,
        String url,
        Integer imageOrder
) {
}
