package com.tuandang.ecommerce_api.api.dto.request.shop;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ShopDtoRequest(
        UUID id,
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        String avatarUrl,
        UUID ownerId
) {
}
