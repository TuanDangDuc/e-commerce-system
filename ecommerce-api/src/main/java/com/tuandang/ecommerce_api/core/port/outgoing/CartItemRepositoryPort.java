package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.CartItem;

import java.util.UUID;

public interface CartItemRepositoryPort {
    public void save(CartItem cartItem);

    public void updateQuantityById(CartItem cartItem);

    public void deleteById(UUID id);
}
