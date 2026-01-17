package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.util.List;
import java.util.UUID;
@Builder
@Data
public class Carts {
    private UUID id;
    private Users owner;
    private Float totalCost;
    private List<CartItem> cartItems;
}
