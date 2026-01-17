package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartItemEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CartsRepository extends JpaRepository<CartsEntity, UUID> {
    @Query("select a.cartItems from CartsEntity a where a.id = :cartId")
    List<CartItemEntity> findAllCartItemById(UUID cartId);
}
