package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ReviewsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.VouchersEntity;

import java.util.UUID;

public class OrderItem {
    private UUID id;

    private Integer quantity;
    private float priceAtPurchase;
    private String status;
    private UUID trackingNumber;
    private String shippingProvider;

    private Product product;
    private Reviews review;
    private Voucher shopVoucher;
}
