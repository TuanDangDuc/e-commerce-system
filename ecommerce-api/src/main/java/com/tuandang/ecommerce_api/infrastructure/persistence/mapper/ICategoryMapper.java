package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.Category;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class ICategoryMapper {
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
}
