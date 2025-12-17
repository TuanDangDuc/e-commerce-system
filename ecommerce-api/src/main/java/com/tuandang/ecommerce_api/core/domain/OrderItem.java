package com.tuandang.ecommerce_api.core.domain;

import lombok.Builder;

import java.util.UUID;

@Builder
public class OrderItem {
    private UUID id;

    private Integer quantity;
    private float priceAtPurchase;
    private String status;
    private UUID trackingNumber;
    private String shippingProvider;

    private Products product;
    private Reviews review;
    private Vouchers shopVouchers;
}
