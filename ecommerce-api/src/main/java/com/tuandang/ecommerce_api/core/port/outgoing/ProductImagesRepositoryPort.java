package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductImagesEntity;

import java.util.List;
import java.util.UUID;

public interface ProductImagesRepositoryPort {
    public void save(List<ProductImages> productImages);
    public List<ProductImages> getAllImageOfProduct(UUID id);
    public void deleteById(UUID id);
}
