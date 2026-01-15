package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.api.dto.request.shop.ShopDtoRequest;
import com.tuandang.ecommerce_api.core.domain.Shops;
import com.tuandang.ecommerce_api.core.port.outgoing.ShopRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepositoryPort  shopRepositoryPort;


    public void create(Shops shop) {
        shopRepositoryPort.save(shop);
    }

    public Shops getShopById(UUID id) {
        return shopRepositoryPort.getShopById(id);
    }

    public void modifyShop(Shops request) {
        shopRepositoryPort.modifyShop(request);
    }

    public void deleteById(UUID id) {
        shopRepositoryPort.deleteById(id);
    }
}
