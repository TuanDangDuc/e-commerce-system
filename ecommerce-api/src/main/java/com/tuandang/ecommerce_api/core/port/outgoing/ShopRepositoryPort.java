package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.api.dto.request.shop.ShopDtoRequest;
import com.tuandang.ecommerce_api.core.domain.Shops;

import java.util.UUID;

public interface ShopRepositoryPort {
    public void save(Shops shop);
    public Shops getShopById(UUID id);

    void modifyShop(Shops request);

    void deleteById(UUID id);
}
