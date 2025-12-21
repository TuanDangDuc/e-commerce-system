package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductsEntity, UUID> {

    @Modifying
    @Transactional
    @Query("update ProductsEntity a set a.name = :#{#pr.name}, a.type = :#{#pr.type}, a.thumbnailUrl = :#{#pr.thumbnailUrl}, a.basePrice = :#{#pr.basePrice}, a.description = :#{#pr.description} ")
    public void update(ProductsEntity pr);
}
