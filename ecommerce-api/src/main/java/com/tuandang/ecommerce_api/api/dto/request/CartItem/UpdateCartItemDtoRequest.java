package com.tuandang.ecommerce_api.api.dto.request.CartItem;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateCartItemDtoRequest(
        @NotNull
        UUID id,
        @NotNull
        Integer quantity
) {
}
