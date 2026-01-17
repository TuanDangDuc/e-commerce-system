package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.port.outgoing.ProductVariantRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductVariantService {
    private final ProductVariantRepositoryPort productVariantRepositoryPort;

    public void create(ProductVariants productVariants) {
        productVariantRepositoryPort.save(productVariants);
    }

    public void deleteById(UUID id) {
        productVariantRepositoryPort.deleteById(id);
    }

    public void update(ProductVariants productVariants) {
        productVariantRepositoryPort.saveCustom(productVariants);
    }
}
