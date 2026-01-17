package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.domain.Carts;
import com.tuandang.ecommerce_api.core.domain.Users;
import com.tuandang.ecommerce_api.core.port.outgoing.CartRepositoryPort;
import com.tuandang.ecommerce_api.core.port.outgoing.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepositoryPort  cartRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    public void createCart(UUID userId) {
        Carts cart = userRepositoryPort.findCartByUserId(userId);
        if (cart != null)
            return;
        cartRepositoryPort.save(Carts.builder()
                        .owner(Users.builder()
                                .id(userId)
                                .build())
                .build());
    }

    public List<CartItem> findAllCartItemById(UUID cartId) {
        return cartRepositoryPort.findAllCartItemById(cartId);
    }
}
