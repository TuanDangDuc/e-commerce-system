package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.domain.Carts;

import java.util.List;
import java.util.UUID;

public interface CartRepositoryPort {
    public void save(Carts cart);

    public List<CartItem> findAllCartItemById(UUID cartId);
}
