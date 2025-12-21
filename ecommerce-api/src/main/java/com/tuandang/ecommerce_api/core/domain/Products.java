package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.core.Enum.Type;
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
    private Type type;
    @Column(
            columnDefinition = "TEXT"
    )
    private String thumbnailUrl;
    private Float basePrice;
    private String description;
    private Users merchant;
    private List<ProductImages> images;
    private List<ProductVariants> variants;
    private List<Category> categories;
    private List<Reviews> reviews;
}
