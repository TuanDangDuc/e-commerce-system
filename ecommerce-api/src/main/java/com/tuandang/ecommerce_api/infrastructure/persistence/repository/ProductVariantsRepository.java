package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductVariantsEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ProductVariantsRepository extends JpaRepository<ProductVariantsEntity, UUID> {

    @Modifying
    @Transactional
    @Query("update ProductVariantsEntity a set " +
            "a.price = :#{#entity.price}, " +
            "a.stock = :#{#entity.stock}," +
            "a.options = :#{#entity.options} where a.id = :#{#entity.id}")
    void saveCustom(ProductVariantsEntity entity);
}
