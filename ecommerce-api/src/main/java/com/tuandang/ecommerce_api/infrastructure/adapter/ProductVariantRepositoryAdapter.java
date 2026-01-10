package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.port.outgoing.ProductVariantRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IProductVariantMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ProductVariantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductVariantRepositoryAdapter implements ProductVariantRepositoryPort {
    private final ProductVariantsRepository productVariantsRepository;
    private final IProductVariantMapper productVariantMapper;

    @Override
    public void createProductVariant(
            ProductVariants productVariants
    ) {
        if (productVariants == null)
            throw new NullPointerException("productVariants should not be null");
        productVariantsRepository.save(productVariantMapper.toEntity(productVariants));
    }
}
