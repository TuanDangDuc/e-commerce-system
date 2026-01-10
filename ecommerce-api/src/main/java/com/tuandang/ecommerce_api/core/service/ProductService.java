package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.core.port.outgoing.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositoryPort productRepositoryPort;

    public void createProduct(Products product) {
        if (product == null)
            throw new NullPointerException("Product should not be null");
        productRepositoryPort.createProduct(product);
    }

    public void delete(UUID id) {
        productRepositoryPort.delete(id);
   }

    public void updateProduct(
            Products product
    ) {
        if (product == null)
            throw new NullPointerException("Product should not be null");
        var base = productRepositoryPort.findById(product.getId());

        if (product.getName().isEmpty())
            product.setName(base.getName());
        if (product.getType() == null)
            product.setType(base.getType());
        if (product.getThumbnailUrl().isEmpty())
            product.setThumbnailUrl(base.getThumbnailUrl());
        if (product.getBasePrice() == 0)
            product.setBasePrice(base.getBasePrice());
        if (product.getDescription().isEmpty())
            product.setDescription(base.getDescription());
        productRepositoryPort.updateProduct(product);
    }
}
