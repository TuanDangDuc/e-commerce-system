package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import jakarta.persistence.Column;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public class Orders {
    private UUID id;
    private UUID orderCode;
    private String recipientName;
    private String recipientPhone;
    private AddressEntity shippingAaddress;
    @Column(columnDefinition = "TEXT")
    private String note;
    private float subtotal;
    private float shippingFee;
    private float discountAmount;
    private float totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime canceledAt;
    private String status;

    private List<OrderItem> orderItems;

    private Vouchers platformVouchers;

    private Vouchers shippingVouchers;
}
