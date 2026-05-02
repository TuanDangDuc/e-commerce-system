package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.Enum.AccountStatus;
import com.tuandang.ecommerce_api.core.domain.Shops;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ShopsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IShopMapper {
    private final UsersRepository userRepository;

    public ShopsEntity toShopsEntity(Shops shop) {
        if (shop == null)
            throw new NullPointerException("shop should not be null");
        return ShopsEntity.builder()
                .id(shop.getId())
                .name(shop.getName())
                .description(shop.getDescription())
                .status(AccountStatus.ACTIVE)
                .ratingAverage(0.0f)
                .avatarUrl(shop.getAvatarUrl())
                .createTime(shop.getCreateTime())
                .owner(userRepository.getReferenceById(shop.getOwner().getId()))
                .build();
    }

    public Shops toShops(ShopsEntity shopsEntity) {
        if (shopsEntity == null)
            throw new NullPointerException("shopsEntity should not be null");

        return Shops.builder()
                .id(shopsEntity.getId())
                .name(shopsEntity.getName())
                .description(shopsEntity.getDescription())
                .ratingAverage(shopsEntity.getRatingAverage())
                .status(shopsEntity.getStatus())
                .avatarUrl(shopsEntity.getAvatarUrl())
                .createTime(shopsEntity.getCreateTime())
                .build();
    }
}
