package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductsEntity;

import java.util.UUID;

public interface ProductRepositoryPort {
    public void createProduct(Products product);
    public void delete(UUID id);
    public void updateProduct(Products product);
    public ProductsEntity findById(UUID id);
}
