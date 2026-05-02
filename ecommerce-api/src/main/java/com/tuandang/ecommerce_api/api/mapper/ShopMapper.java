package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.shop.ShopDtoRequest;
import com.tuandang.ecommerce_api.core.domain.Shops;
import com.tuandang.ecommerce_api.core.domain.Users;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class ShopMapper {
    public Shops toShop(
            ShopDtoRequest request
    ) {
        return Shops.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .avatarUrl(request.avatarUrl())
                .owner(Users.builder()
                        .id(request.ownerId())
                        .build())
                .build();
    }
}
