package com.tuandang.ecommerce_api.core.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.OrderItemEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.VouchersEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
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

    private Voucher platformVoucher;

    private Voucher shippingVoucher;
}
