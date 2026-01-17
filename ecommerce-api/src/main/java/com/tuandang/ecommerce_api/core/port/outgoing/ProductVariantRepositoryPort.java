package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;

import java.util.UUID;

public interface ProductVariantRepositoryPort {
    public void save(ProductVariants productVariants);

    public void deleteById(UUID id);

    public void saveCustom(ProductVariants productVariants);
}
