package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.Addresses;

public interface AddressRepositoryPort {
    public void save(Addresses address);
}
