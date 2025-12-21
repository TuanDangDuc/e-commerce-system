package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductImagesEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductsEntity;
import org.springframework.stereotype.Service;

@Service
public class IProductImageMapper {
    public ProductImagesEntity toProductImagesEntity(ProductImages productImages){
        return ProductImagesEntity.builder()
                .url(productImages.getUrl())
                .product(ProductsEntity.builder()
                        .id(productImages.getProduct().getId())
                        .build())
                .imageOrder(productImages.getImageOrder())
                .build();
    }

    public ProductImages toProductImages(
            ProductImagesEntity productImagesEntity
    ){
        return ProductImages.builder()
                .id(productImagesEntity.getId())
                .url(productImagesEntity.getUrl())
                .imageOrder(productImagesEntity.getImageOrder())
                .build();
    }
}
