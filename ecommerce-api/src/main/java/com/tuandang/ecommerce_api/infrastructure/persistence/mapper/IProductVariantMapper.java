package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductVariantsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductsEntity;
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
                .product(ProductsEntity.builder()
                        .id(productVariants.getProduct().getId())
                        .build())
                .build();
    }

    public ProductVariants toProductVariants(ProductVariantsEntity productVariantsEntity) {
        if (productVariantsEntity == null)
            throw new NullPointerException("productVariantsEntity should not be null!");
        return ProductVariants.builder()
                .id(productVariantsEntity.getId())
                .price(productVariantsEntity.getPrice())
                .stock(productVariantsEntity.getStock())
                .options(productVariantsEntity.getOptions())
                .build();
    }
}
