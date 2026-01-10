package com.tuandang.ecommerce_api.api.dto.request.productVariants;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record AddProductVariantDtoRequest(
        @NotNull
        float price,
        @NotNull
        Integer stock,
        @NotBlank
        Map<String, String>options
) {
}
