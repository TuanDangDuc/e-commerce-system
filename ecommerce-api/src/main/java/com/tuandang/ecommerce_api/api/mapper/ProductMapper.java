package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.products.AddProductDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.products.UpdateProductDtoRequest;
import com.tuandang.ecommerce_api.core.domain.Category;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.core.domain.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMapper {
    public Products AddProductDtoToProduct(
        AddProductDtoRequest request
    ) {
        List<Category> categories = new ArrayList<>();
        for (var s : request.categories()) {
            categories.add(Category.builder()
                    .id(s)
                    .build());
        }
        return Products.builder()
                .name(request.name())
                .type(request.type())
                .thumbnailUrl(request.thumbnailUrl())
                .basePrice(request.basePrice())
                .description(request.description())
                .merchant(Users.builder()
                        .id(request.userId())
                        .build())
                .categories(categories)
                .build();
    }

    public Products UpdateProductDtoToProduct(
            UpdateProductDtoRequest request
    ) {
        return Products.builder()
                .id(request.id())
                .name(request.name())
                .type(request.type())
                .thumbnailUrl(request.thumbnailUrl())
                .basePrice(request.basePrice())
                .description(request.description())
                .build();
    }
}
