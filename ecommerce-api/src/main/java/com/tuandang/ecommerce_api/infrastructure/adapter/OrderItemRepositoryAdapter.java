package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.core.domain.OrderItem;
import com.tuandang.ecommerce_api.core.port.outgoing.OrderItemRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IOrderItemMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderItemRepositoryAdapter implements OrderItemRepositoryPort {
    private final OrderItemRepository orderItemRepository;
    private final IOrderItemMapper  orderItemMapper;

    public List<OrderItem> getAllOrderItemByShopId(UUID shopId) {
        return orderItemRepository.getAllOrderItemByShopId(shopId)
                .stream()
                .map(orderItemMapper::toOrderItem)
                .toList();
    }
}
