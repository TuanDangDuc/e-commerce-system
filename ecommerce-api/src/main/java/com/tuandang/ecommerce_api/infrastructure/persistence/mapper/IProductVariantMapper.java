package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductVariantsEntity;
import org.springframework.stereotype.Service;

@Service
public class IProductVariantMapper {
    public ProductVariantsEntity toEntity(
            ProductVariants productVariants
    ) {
        if  (productVariants == null)
            throw new NullPointerException("productVariants should not be null!");
        return ProductVariantsEntity.builder()
                .id(productVariants.getId())
                .price(productVariants.getPrice())
                .stock(productVariants.getStock())
                .options(productVariants.getOptions())
                .build();
    }
}
