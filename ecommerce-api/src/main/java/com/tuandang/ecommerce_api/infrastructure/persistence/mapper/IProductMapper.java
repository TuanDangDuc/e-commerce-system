package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.Category;
import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.*;
import org.springframework.stereotype.Service;

@Service
public class IProductMapper {
    public ProductImagesEntity toProductImagesEntity(
            ProductImages productImages
    ){
        if  (productImages == null)
            throw new NullPointerException("productImages should not be null!");
        return ProductImagesEntity.builder()
                .url(productImages.getUrl())
                .imageOrder(productImages.getImageOrder())
                .build();
    }

    public ProductVariantsEntity toProductVariantsEntity(
            ProductVariants variants
    ) {
        if (variants == null)
            throw new NullPointerException("variants should not be null!");
        return ProductVariantsEntity.builder()
                .price(variants.getPrice())
                .stock(variants.getStock())
                .options(variants.getOptions())
                .build();
    }
    public CategoryEntity toCategoryEntity(
            Category category
    ) {
        if (category == null)
            throw new NullPointerException("category should not be null!");
        return CategoryEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
    public ProductsEntity toProductEntity(
            Products product
    ) {
        if (product == null)
            throw new NullPointerException("product should not be null!");
        var mer = UsersEntity.builder()
                .id(product.getMerchant().getId())
                .build();
        return ProductsEntity.builder()
                .name(product.getName())
                .type(product.getType())
                .thumbnailUrl(product.getThumbnailUrl())
                .basePrice(product.getBasePrice())
                .description(product.getDescription())
                .merchant(mer)
                .categories(product.getCategories()
                        .stream()
                        .map(this::toCategoryEntity)
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
}
