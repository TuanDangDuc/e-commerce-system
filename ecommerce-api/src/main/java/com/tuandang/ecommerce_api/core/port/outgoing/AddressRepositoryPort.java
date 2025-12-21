package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.Addresses;

import java.util.UUID;

public interface AddressRepositoryPort {
    public void save(Addresses address);
    public void delete(UUID id);
    public void update(Addresses address);
    public Addresses findById(UUID id);
}
