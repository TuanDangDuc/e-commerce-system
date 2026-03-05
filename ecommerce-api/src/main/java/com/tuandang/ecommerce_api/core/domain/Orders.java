package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.core.Enum.OrderStatus;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class Orders {
    private UUID id;
    private String orderCode;
    private String recipientName;
    private String recipientPhone;
    private Addresses shippingAddress;
    @Column(columnDefinition = "TEXT")
    private String note;
    private Float subtotal;
    private Float shippingFee;
    private Float discountAmount;
    private Float totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime canceledAt;
    private OrderStatus status;

    private List<OrderItem> orderItems;

    private Vouchers platformVouchers;

    private Vouchers shippingVouchers;
}
