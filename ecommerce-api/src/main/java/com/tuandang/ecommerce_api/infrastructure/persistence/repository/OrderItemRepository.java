package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, UUID> {
    @Query("select a, pv.id, pv.options, p.name, p.thumbnailUrl, p.description  from OrderItemEntity a join ProductVariantsEntity pv join ProductsEntity p where a.shopId = :shopId")
    public List<OrderItemEntity> getAllOrderItemByShopId(UUID shopId);
}
