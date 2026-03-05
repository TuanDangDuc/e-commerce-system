package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.Orders;

public interface OrderRepositoryPort {
    public void save(Orders order);
}
