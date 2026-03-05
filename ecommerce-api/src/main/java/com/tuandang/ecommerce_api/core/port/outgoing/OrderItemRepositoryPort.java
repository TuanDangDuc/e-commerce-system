package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.OrderItem;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepositoryPort {
    public List<OrderItem> getAllOrderItemByShopId(UUID shopId);
}
