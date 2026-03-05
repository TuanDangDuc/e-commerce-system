package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.Enum.OrderStatus;
import com.tuandang.ecommerce_api.core.domain.Orders;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.OrderItemEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.OrdersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.VouchersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.AddressRepository;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.VouchersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IOrderMapper {
    private final IOrderItemMapper orderItemMapper;
    private final AddressRepository addressRepository;
    private final VouchersRepository  vouchersRepository;

    public OrdersEntity toEntity(Orders order) {
        if (order == null)
            throw new NullPointerException("order should not be null");
        var builder = OrdersEntity.builder()
                .orderCode(order.getOrderCode())
                .recipientName(order.getRecipientName())
                .recipientPhone(order.getRecipientPhone())
                .shippingAddress(addressRepository.getReferenceById(order.getShippingAddress().getId()))
                .note(order.getNote())
                .subtotal(order.getSubtotal())
                .shippingFee(order.getShippingFee())
                .discountAmount(order.getDiscountAmount())
                .totalAmount(order.getTotalAmount())
                .status(OrderStatus.PENDING)
                .orderItems(order.getOrderItems()
                        .stream()
                        .map(orderItemMapper::toOrderItemEntity)
                        .toList());
        if (order.getPlatformVouchers().getId() != null) {
            builder.platformVoucher(vouchersRepository.getReferenceById(order.getPlatformVouchers().getId()));
        }
        if (order.getShippingVouchers().getId() != null) {
            builder.shippingVoucher(vouchersRepository.getReferenceById(order.getShippingVouchers().getId()));
        }
        return builder.build();
    }
}
