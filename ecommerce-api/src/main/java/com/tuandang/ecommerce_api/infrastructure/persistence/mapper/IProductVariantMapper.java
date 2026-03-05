package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductVariantsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IProductVariantMapper {
    private final ProductRepository productRepository;

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
                .product(productRepository.getReferenceById(productVariants.getProduct().getId()))
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
