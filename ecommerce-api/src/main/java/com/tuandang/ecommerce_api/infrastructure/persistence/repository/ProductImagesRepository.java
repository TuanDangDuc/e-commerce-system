package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductImagesRepository extends JpaRepository<ProductImagesEntity, UUID> {
    public List<ProductImagesEntity> findByProductId(UUID productId);

    @Query("select max(a.imageOrder) from ProductImagesEntity a where a.product.id = :productId")
    public Integer findMaxImageOrderByProductId(UUID productId);
}
