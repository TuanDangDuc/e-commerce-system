package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.CartItem.CartItemDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.CartItem.UpdateCartItemDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.CartItemDtoResponse;
import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.domain.Carts;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {
    public CartItem toCartItem(CartItemDtoRequest request) {
        return CartItem.builder()
                .id(request.id())
                .quantity(request.quantity())
                .price(request.price())
                .cart(Carts.builder()
                        .id(request.cartId())
                        .build())
                .productVariant(ProductVariants.builder()
                        .id(request.productVariantId())
                        .build())
                .build();
    }

    public CartItem toUpdateQuantityCartItem(UpdateCartItemDtoRequest request) {
        return CartItem.builder()
                .id(request.id())
                .quantity(request.quantity())
                .build();
    }

    public CartItemDtoResponse toCartItemDtoResponse(CartItem cartItem) {
        return CartItemDtoResponse.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .price(cartItem.getPrice())
                .productVariant(cartItem.getProductVariant())
                .build();
    }
}
