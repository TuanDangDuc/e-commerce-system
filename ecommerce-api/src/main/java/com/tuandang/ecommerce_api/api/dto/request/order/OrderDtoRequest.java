package com.tuandang.ecommerce_api.api.dto.request.order;

import com.tuandang.ecommerce_api.api.dto.request.orderItem.OrderItemDtoRequest;
import com.tuandang.ecommerce_api.core.Enum.OrderStatus;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record OrderDtoRequest(
        @NotEmpty
        String orderCode,
        @NotBlank
        String recipientName,
        @NotBlank
        String recipientPhone,
        @NotBlank
        String note,
        @NotNull
        Float subtotal,
        @NotNull
        Float shippingFee,
        @NotNull
        Float discountAmount,
        @NotNull
        Float totalAmount,
        @NotNull
        UUID shippingAddressId,
        UUID platformVoucherId,
        UUID shippingVoucherId,
        @NotEmpty
        List<OrderItemDtoRequest> items
) {
}
