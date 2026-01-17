package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItemEntity, UUID> {

    @Modifying
    @Transactional
    @Query("update CartItemEntity a set a.quantity = :#{#cartItemEntity.quantity} where a.id = :#{#cartItemEntity.id}")
    void updateQuantityById(CartItemEntity cartItemEntity);
}
