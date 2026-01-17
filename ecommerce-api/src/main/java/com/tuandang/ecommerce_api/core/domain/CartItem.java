package com.tuandang.ecommerce_api.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class CartItem {
    private UUID id;
    private Integer quantity;
    private float price;
    private Carts cart;
    private ProductVariants productVariant;
}
