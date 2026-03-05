package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.Carts;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ICartMapper {
    private final ICartItemMapper cartItemMapper;
    private final UsersRepository usersRepository;

    public CartsEntity toCartEntity(Carts cart) {
        return CartsEntity.builder()
                .id(cart.getId())
                .totalCost(0.0F)
                .cartOwner(usersRepository.getReferenceById(cart.getOwner().getId()))
                .build();
    }

    public Carts toCart(CartsEntity cart) {
        if (cart == null)
            return null;
        return Carts.builder()
                .id(cart.getId())
                .totalCost(cart.getTotalCost())
                .build();
    }
}
