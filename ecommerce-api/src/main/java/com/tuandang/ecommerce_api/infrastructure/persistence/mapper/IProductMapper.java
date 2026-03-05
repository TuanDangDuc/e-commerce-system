package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.Category;
import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.*;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ShopsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class IProductMapper {
    private final ShopsRepository shopsRepository;
    private final ICategoryMapper categoryMapper;

    public ProductsEntity toProductEntity(
            Products product
    ) {
        if (product == null)
            throw new NullPointerException("product should not be null!");
        return ProductsEntity.builder()
                .name(product.getName())
                .type(product.getType())
                .thumbnailUrl(product.getThumbnailUrl())
                .basePrice(product.getBasePrice())
                .description(product.getDescription())
                .shop(shopsRepository.getReferenceById(product.getShops().getId()))
                .categories(product.getCategories()
                        .stream()
                        .map(categoryMapper::toCategoryEntity)
                        .toList())
                .build();
    }
    public ProductsEntity toProductEntityWithoutUser(
            Products product
    ) {
        if (product == null)
            throw new NullPointerException("product should not be null!");
        return ProductsEntity.builder()
                .name(product.getName())
                .type(product.getType())
                .thumbnailUrl(product.getThumbnailUrl())
                .basePrice(product.getBasePrice())
                .description(product.getDescription())
                .build();
    }

    public Products toProduct(
            ProductsEntity productsEntity
    ) {
        if (productsEntity == null)
            throw new NullPointerException("productsEntity should not be null!");

        return Products.builder()
                .id(productsEntity.getId())
                .name(productsEntity.getName())
                .type(productsEntity.getType())
                .thumbnailUrl(productsEntity.getThumbnailUrl())
                .basePrice(productsEntity.getBasePrice())
                .description(productsEntity.getDescription())
                .build();
    }
}
