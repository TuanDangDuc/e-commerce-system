package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.port.outgoing.CartItemRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemRepositoryPort  cartItemRepositoryPort;

    public void save(CartItem cartItem) {
        cartItemRepositoryPort.save(cartItem);
    }

    public void updateQuantityById(CartItem cartItem) {
        cartItemRepositoryPort.updateQuantityById(cartItem);
    }

    public void deleteById(UUID id) {
        cartItemRepositoryPort.deleteById(id);
    }
}
