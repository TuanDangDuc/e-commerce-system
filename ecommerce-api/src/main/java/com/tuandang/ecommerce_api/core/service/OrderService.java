package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.core.domain.Orders;
import com.tuandang.ecommerce_api.core.port.outgoing.OrderRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepositoryPort orderRepositoryPort;
    private final ProductVariantService productVariantService;

    public void addOrder(
            Orders order
    ) {
        for (var s : order.getOrderItems())
            productVariantService.updateStock(s.getId(), s.getQuantity());
        orderRepositoryPort.save(order);
    }
}
