package com.tuandang.ecommerce_api.api.dto.response;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CartItemDtoResponse(
        UUID id,
        Integer quantity,
        float price,
        ProductVariants  productVariant
) {
}
