package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;

public interface ProductVariantRepositoryPort {
    public void createProductVariant(ProductVariants productVariants);
}
