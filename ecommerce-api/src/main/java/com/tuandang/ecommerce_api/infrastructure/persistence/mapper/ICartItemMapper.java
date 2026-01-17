package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartItemEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductVariantsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ICartItemMapper {
    private final IProductVariantMapper productVariantMapper;

    public CartItemEntity toCartItemEntity(CartItem cartItem) {
        if (cartItem == null)
            throw new NullPointerException("cartItem should not be null");

        return CartItemEntity.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .price(cartItem.getPrice())
                .cart(CartsEntity.builder()
                        .id(cartItem.getCart().getId())
                        .build())
                .productVariants(ProductVariantsEntity.builder()
                        .id(cartItem.getProductVariant().getId())
                        .build())
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
