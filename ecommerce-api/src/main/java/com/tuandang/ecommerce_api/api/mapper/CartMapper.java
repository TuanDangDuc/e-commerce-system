package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.response.CartDtoResponse;
import com.tuandang.ecommerce_api.core.domain.Carts;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public CartDtoResponse toCartDtoResponse(
            Carts cart
    ) {
        return CartDtoResponse.builder()
                .id(cart.getId())
                .totalCost(cart.getTotalCost())
                .build();
    }
}
