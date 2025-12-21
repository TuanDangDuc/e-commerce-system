package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.core.port.outgoing.ProductImagesRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductImagesEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IProductImageMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ProductImagesRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProductImagesRepositoryAdapter implements ProductImagesRepositoryPort {
    private final ProductImagesRepository productImagesRepository;
    private final IProductImageMapper  productImageMapper;
    public ProductImagesRepositoryAdapter(
            ProductImagesRepository productImagesRepository,
            IProductImageMapper productImageMapper
    ) {
        this.productImagesRepository = productImagesRepository;
        this.productImageMapper = productImageMapper;
    }

    @Override
    public void save(List<ProductImages> productImages) {
        var test = productImagesRepository.findMaxImageOrderByProductId(productImages.getFirst().getProduct().getId());
        int count = 0;
        if (test != null)
            count = test + 1;

        for (var s : productImages) {
            s.setImageOrder(count++);
            productImagesRepository.save(productImageMapper.toProductImagesEntity(s));
        }
    }

    @Override
    public List<ProductImages> getAllImageOfProduct(
            UUID id
    ) {
        return productImagesRepository.findByProductId(id)
                .stream()
                .map(productImageMapper::toProductImages)
                .toList();
    }

    @Override
    public void deleteById(
            UUID id
    ) {
        productImagesRepository.deleteById(id);
    }
}
