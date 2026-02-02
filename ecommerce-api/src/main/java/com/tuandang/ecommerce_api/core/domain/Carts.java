package com.tuandang.ecommerce_api.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carts {
    private UUID id;
    private Users owner;
    private Float totalCost;
    private List<CartItem> cartItems;

    public Float CalculateTotalPrice() {
        return cartItems
                .stream()
                .map(cartItem -> cartItem.getPrice() *  cartItem.getQuantity())
                .reduce(0F, Float::sum);
    }
}
