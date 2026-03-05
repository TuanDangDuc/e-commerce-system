package com.tuandang.ecommerce_api.api.dto.response;

import com.tuandang.ecommerce_api.core.Enum.OrderStatus;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import lombok.Builder;

import java.util.Map;
import java.util.UUID;

@Builder
public record OrderItemDtoResponse(
        UUID id,
        Integer quantity,
        Float priceAtPurchase,
        OrderStatus status,
        UUID trackingNumber,
        String shippingProvider,

        // variant
        UUID productVariantsId,
        Map<String, String> options,
        // product
        String name,
        String thumbnailUrl,
        String description
) {
}
