package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.Shops;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ShopsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IShopMapper {
    private final UsersRepository usersRepository;
    public ShopsEntity toShopsEntity(Shops shop) {
        if (shop == null)
            throw new NullPointerException("shop should not be null");
        var user = usersRepository.findUsersEntitiesById(shop.getOwner().getId());
        System.out.println(" id = "  + shop.getOwner().getId());
        return ShopsEntity.builder()
                .id(shop.getId())
                .name(shop.getName())
                .description(shop.getDescription())
                .ratingAverage(shop.getRatingAverage())
                .status(shop.getStatus())
                .avatarUrl(shop.getAvatarUrl())
                .createTime(shop.getCreateTime())
                .owner(user)
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
