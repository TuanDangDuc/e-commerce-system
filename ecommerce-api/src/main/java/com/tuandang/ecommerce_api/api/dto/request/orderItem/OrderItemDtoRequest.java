package com.tuandang.ecommerce_api.api.dto.request.orderItem;

import com.tuandang.ecommerce_api.core.Enum.OrderStatus;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record OrderItemDtoRequest(
        @NotNull
        Integer quantity,
        @NotNull
        Float priceAtPurchase,
        @NotNull
        UUID trackingNumber,
        UUID shopId,
        String shippingProvider,
        @NotNull
        UUID productVariantId,
        UUID shopVoucherID
) {
}
