package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.api.dto.response.OrderItemDtoResponse;
import com.tuandang.ecommerce_api.core.domain.OrderItem;
import com.tuandang.ecommerce_api.core.port.outgoing.OrderItemRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepositoryPort orderItemRepositoryPort;

    public List<OrderItem> getAllOrderByShopId(UUID shopId) {
        return orderItemRepositoryPort.getAllOrderItemByShopId(shopId);
    }
}
