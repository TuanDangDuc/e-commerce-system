package com.tuandang.ecommerce_api.api.dto.request.products;

import com.tuandang.ecommerce_api.core.Enum.Type;
import com.tuandang.ecommerce_api.core.domain.Category;
import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.UUID;

public record AddProductDtoRequest(
        @NotNull
        UUID userId,
        @NotBlank
        String name,
        @NotBlank
        Type type,
        @NotBlank
        String thumbnailUrl,
        @NotNull
        Float basePrice,
        @NotBlank
        String description,
        @NotEmpty
        List<UUID> categories
) {
}
