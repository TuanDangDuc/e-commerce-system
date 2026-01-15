package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ShopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ShopsRepository extends JpaRepository<ShopsEntity, UUID> {

    @Modifying
    @Transactional
    @Query("update ShopsEntity a set " +
            "a.name = :#{#shopsEntity.name}, " +
            "a.description = :#{#shopsEntity.description}, " +
            "a.avatarUrl = :#{#shopsEntity.avatarUrl}, " +
            "a.status = :#{#shopsEntity.status} " +
            "where a.id = :#{#shopsEntity.id}")
    void saveCustom(ShopsEntity shopsEntity);
}
