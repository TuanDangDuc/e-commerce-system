package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.Category;
import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.*;
import org.springframework.stereotype.Service;

@Service
public class IProductMapper {
    private final IUserMapper userMapper;
    public IProductMapper(
            IUserMapper userMapper
    ) {
        this.userMapper = userMapper;
    }
    public ProductImagesEntity toProductImagesEntity(
            ProductImages productImages
    ){
        return ProductImagesEntity.builder()
                .url(productImages.getUrl())
                .imageOrder(productImages.getImageOrder())
                .build();
    }

    public ProductVariantsEntity toProductVariantsEntity(
            ProductVariants variants
    ) {
        return ProductVariantsEntity.builder()
                .price(variants.getPrice())
                .stock(variants.getStock())
                .options(variants.getOptions())
                .build();
    }
    public CategoryEntity toCategoryEntity(
            Category category
    ) {
        return CategoryEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
    public ProductsEntity toProductEntity(
            Products product
    ) {

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
        return ProductsEntity.builder()
                .name(product.getName())
                .type(product.getType())
                .thumbnailUrl(product.getThumbnailUrl())
                .basePrice(product.getBasePrice())
                .description(product.getDescription())
                .build();
    }
}
