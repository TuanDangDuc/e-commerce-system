package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.domain.Carts;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartItemEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface CartsRepository extends JpaRepository<CartsEntity, UUID> {
    @Query("select a.cartItems from CartsEntity a where a.id = :cartId")
    List<CartItemEntity> findAllCartItemById(UUID cartId);

    @Modifying
    @Transactional
    @Query("update CartsEntity a set a.totalCost = :totalCost where a.cartOwner.id = :userId")
    void saveTotalCostOfCartByUserId(UUID userId, Float totalCost);

    @Query("select a.id, a.totalCost from CartsEntity a where a.cartOwner.id = :userId")
    CartsEntity getCartsEntitiesByUserId(UUID userId);

    @Query("select a.cartItems from CartsEntity a where a.cartOwner.id = :userId")
    List<CartItemEntity> getAllCartItemByUserId(UUID userId);
}
