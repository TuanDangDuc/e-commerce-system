package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.*;
import jakarta.persistence.Column;

import java.util.List;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String type;
    @Column(
            columnDefinition = "TEXT"
    )
    private String thumbnailUrl;
    private float basePrice;
    private List<ProductImagesEntity> images;
    private List<ProductOptionEntity> options;
    private List<ProductVariantsEntity> variants;
    private List<CategoryEntity> categories;
    private List<ReviewsEntity> reviews;
}
