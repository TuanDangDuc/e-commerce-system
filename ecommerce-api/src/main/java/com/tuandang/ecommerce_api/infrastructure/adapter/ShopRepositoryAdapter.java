package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.core.domain.Shops;
import com.tuandang.ecommerce_api.core.port.outgoing.ShopRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IShopMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ShopsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ShopRepositoryAdapter implements ShopRepositoryPort {
    private final ShopsRepository shopsRepository;
    private final IShopMapper  shopMapper;


    @Override
    public void save(Shops shop) {
        shopsRepository.save(shopMapper.toShopsEntity(shop));
    }

    @Override
    public Shops getShopById(UUID id) {

        return shopMapper.toShops(shopsRepository.findById(id)
                .orElse(null));
    }

    @Override
    public void modifyShop(Shops request) {
        shopsRepository.saveCustom(shopMapper.toShopsEntity(request));
    }

    @Override
    public void deleteById(UUID id) {
        shopsRepository.deleteById(id);
    }
}
