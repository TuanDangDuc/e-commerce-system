package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.domain.Carts;
import com.tuandang.ecommerce_api.core.port.outgoing.CartRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.ICartItemMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.ICartMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.CartsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CartRepositoryAdapter implements CartRepositoryPort {
    private final CartsRepository cartsRepository;
    private final ICartMapper  cartMapper;
    private final ICartItemMapper cartItemMapper;

    @Override
    public void save(Carts cart) {
        cartsRepository.save(cartMapper.toCartEntity(cart));
    }

    @Override
    public List<CartItem> findAllCartItemById(UUID cartId) {
        return cartsRepository.findAllCartItemById(cartId)
                .stream()
                .map(cartItemMapper::toCartItem)
                .toList();
    }
}
