package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.productImage.AddImagesDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.ProductImageDtoResponse;
import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductImagesEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImageMapper {
    public List<ProductImages> toProductImages(
            AddImagesDtoRequest request
    ){
        List<ProductImages> urls = new ArrayList<>();
        for (var item : request.getImages()) {
            urls.add(
                    ProductImages.builder()
                            .url(item)
                            .product(Products.builder()
                                    .id(request.getProductId())
                                    .build())
                            .build()
            );
        }
        return urls;
    }

    public ProductImageDtoResponse productImageDtoResponses(
            ProductImages productImages
    ){
        return  ProductImageDtoResponse.builder()
                .id(productImages.getId())
                .url(productImages.getUrl())
                .imageOrder(productImages.getImageOrder())
                .build();
    }
}
