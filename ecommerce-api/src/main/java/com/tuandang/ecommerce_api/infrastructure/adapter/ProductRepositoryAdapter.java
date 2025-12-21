package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.api.mapper.ProductMapper;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.core.port.outgoing.ProductRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IProductMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ProductRepository;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductRepository productRepository;
    private final IProductMapper productMapper;
    public ProductRepositoryAdapter(
            ProductRepository productRepository,
            IProductMapper productMapper
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public void createProduct(Products product) {
        productRepository.save(productMapper.toProductEntity(product));
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Products product) {
        productRepository.update(productMapper.toProductEntityWithoutUser(product));
    }

    @Override
    public ProductsEntity findById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Product not found"));
    }

}
