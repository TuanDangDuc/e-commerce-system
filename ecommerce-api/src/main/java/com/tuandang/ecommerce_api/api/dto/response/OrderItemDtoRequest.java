package com.tuandang.ecommerce_api.api.dto.response;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Reviews;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
public record OrderItemDtoRequest(
        UUID id,
        @NotNull
        Integer quantity,
        @NotNull
        float priceAtPurchase,
        @NotBlank
        String status,
        @NotNull
        UUID trackingNumber,
        @NotBlank
        String shippingProvider,
        @NotNull
        UUID productVariantId,
        Reviews review,
        Vouchers shopVouchers
) {
}
