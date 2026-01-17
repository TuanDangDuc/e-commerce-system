package com.tuandang.ecommerce_api.api.dto.request.CartItem;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CartItemDtoRequest(
        UUID id,
        @NotNull
        Integer quantity,
        @NotNull
        float price,
        @NotNull
        UUID cartId,
        @NotNull
        UUID productVariantId
) {
}
