package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductImagesEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IProductImageMapper {
    private final ProductRepository productRepository;

    public ProductImagesEntity toProductImagesEntity(
            ProductImages productImages
    ){
        if (productImages == null)
            throw new NullPointerException("productImages should not be null!");
        return ProductImagesEntity.builder()
                .url(productImages.getUrl())
                .product(productRepository.getReferenceById(productImages.getProduct().getId()))
                .imageOrder(productImages.getImageOrder())
                .build();
    }

    public ProductImages toProductImages(
            ProductImagesEntity productImagesEntity
    ){
        if  (productImagesEntity == null)
            throw new NullPointerException("productImagesEntity should not be null!");
        return ProductImages.builder()
                .id(productImagesEntity.getId())
                .url(productImagesEntity.getUrl())
                .imageOrder(productImagesEntity.getImageOrder())
                .build();
    }
}
