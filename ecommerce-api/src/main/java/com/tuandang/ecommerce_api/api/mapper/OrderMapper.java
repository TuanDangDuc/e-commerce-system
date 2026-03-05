package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.order.OrderDtoRequest;
import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.core.domain.Orders;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final OrderItemMapper orderItemMapper;

    public Orders toOrders(OrderDtoRequest request) {
        if (request == null)
            throw new NullPointerException("request should not be null");
        return Orders.builder()
                .orderCode(request.orderCode())
                .recipientName(request.recipientName())
                .recipientPhone(request.recipientPhone())
                .note(request.note())
                .subtotal(request.subtotal())
                .shippingFee(request.shippingFee())
                .discountAmount(request.discountAmount())
                .totalAmount(request.totalAmount())
                .shippingAddress(Addresses.builder()
                        .id(request.shippingAddressId())
                        .build())
                .shippingVouchers(Vouchers.builder()
                        .id(request.shippingVoucherId())
                        .build())
                .platformVouchers(Vouchers.builder()
                        .id(request.platformVoucherId())
                        .build())
                .orderItems(request.items()
                        .stream()
                        .map(orderItemMapper::toOrderItem)
                        .toList())
                .build();
    }
}
