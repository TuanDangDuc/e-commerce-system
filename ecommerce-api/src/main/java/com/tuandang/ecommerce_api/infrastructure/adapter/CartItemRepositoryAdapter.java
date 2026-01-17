package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.api.mapper.CartItemMapper;
import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.port.outgoing.CartItemRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.ICartItemMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartItemRepositoryAdapter implements CartItemRepositoryPort {
    private final CartItemRepository cartItemRepository;
    private final ICartItemMapper iCartItemMapper;

    @Override
    public void save(CartItem cartItem) {
        cartItemRepository.save(iCartItemMapper.toCartItemEntity(cartItem));
    }

    @Override
    public void updateQuantityById(CartItem cartItem) {
        cartItemRepository.updateQuantityById(iCartItemMapper.toUpdateQuantityCartItemEntity(cartItem));
    }

    @Override
    public void deleteById(UUID id) {
        cartItemRepository.deleteById(id);
    }
}
