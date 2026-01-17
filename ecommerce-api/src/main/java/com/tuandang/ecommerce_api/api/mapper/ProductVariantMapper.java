package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.productVariants.ProductVariantDtoRequest;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductVariantMapper {

    public ProductVariants toProductVariants(
            ProductVariantDtoRequest request
    ) {
        return ProductVariants.builder()
                .id(request.id())
                .price(request.price())
                .stock(request.stock())
                .options(request.options())
                .product(Products.builder()
                        .id(request.productId())
                        .build())
                .build();
    }
}
