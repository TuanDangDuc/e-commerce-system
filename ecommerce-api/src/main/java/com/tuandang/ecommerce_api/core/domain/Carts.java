package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartItemEntity;

import java.util.List;
import java.util.UUID;

public class Carts {
    private UUID id;
    private List<CartItem> cartItems;
}
