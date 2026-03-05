package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.core.Enum.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class OrderItem {
    private UUID id;
    private Integer quantity;
    private Float priceAtPurchase;
    private OrderStatus status;
    private UUID trackingNumber;
    private UUID shopId;
    private String shippingProvider;
    private Orders orders;
    private ProductVariants productVariant;
    private Reviews review;
    private Vouchers shopVouchers;
}
