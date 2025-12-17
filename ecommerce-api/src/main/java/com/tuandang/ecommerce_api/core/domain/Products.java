package com.tuandang.ecommerce_api.core.domain;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class Products {
    private UUID id;
    private String name;
    private String type;
    @Column(
            columnDefinition = "TEXT"
    )
    private String thumbnailUrl;
    private float basePrice;
    private List<ProductImages> images;
    private List<ProductVariants> variants;
    private List<Category> categories;
    private List<Reviews> reviews;
}
