package com.tuandang.ecommerce_api.api.dto.request.products;

import com.tuandang.ecommerce_api.core.Enum.Type;

import java.util.UUID;

public record UpdateProductDtoRequest(
        UUID id,
        String name,
        Type type,
        String thumbnailUrl,
        Float basePrice,
        String description
) {
}
