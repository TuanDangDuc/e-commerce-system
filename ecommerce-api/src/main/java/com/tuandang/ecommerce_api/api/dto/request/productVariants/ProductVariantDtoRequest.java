package com.tuandang.ecommerce_api.api.dto.request.productVariants;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Map;
import java.util.UUID;

public record ProductVariantDtoRequest(
        UUID id,
        UUID productId,
        @NotNull
        float price,
        @NotNull
        Integer stock,
        @NotBlank
        Map<String, String>options
) {
}
