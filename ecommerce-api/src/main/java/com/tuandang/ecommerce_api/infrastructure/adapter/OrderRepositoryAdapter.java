package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.core.domain.Orders;
import com.tuandang.ecommerce_api.core.port.outgoing.OrderRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IOrderMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepositoryPort {
    private final OrderRepository orderRepository;
    private final IOrderMapper orderMapper;

    public void save(Orders order) {
        orderRepository.save(orderMapper.toEntity(order));
    }
}
