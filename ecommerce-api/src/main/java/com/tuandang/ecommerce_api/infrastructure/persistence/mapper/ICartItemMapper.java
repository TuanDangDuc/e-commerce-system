package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartItemEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductVariantsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.CartsRepository;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ProductVariantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ICartItemMapper {
    private final IProductVariantMapper productVariantMapper;
    private final CartsRepository cartsRepository;
    private final ProductVariantsRepository productVariantsRepository;

    public CartItemEntity toCartItemEntity(CartItem cartItem) {
        if (cartItem == null)
            throw new NullPointerException("cartItem should not be null");

        return CartItemEntity.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .price(cartItem.getPrice())
                .cart(cartsRepository.getReferenceById(cartItem.getCart().getId()))
                .productVariants(productVariantsRepository.getReferenceById(cartItem.getProductVariant().getId()))
                .build();
    }

    public CartItemEntity toUpdateQuantityCartItemEntity(CartItem cartItem) {
        if (cartItem == null)
            throw new NullPointerException("cartItem should not be null");
        return CartItemEntity.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .build();
    }

    public CartItem toCartItem(CartItemEntity cartItem) {
        if (cartItem == null)
            throw new NullPointerException("cartItem should not be null");
        return CartItem.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .price(cartItem.getPrice())
                .productVariant(productVariantMapper.toProductVariants(cartItem.getProductVariants()))
                .build();
    }
}
