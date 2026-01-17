package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.productVariants.ProductVariantDtoRequest;
import com.tuandang.ecommerce_api.api.mapper.ProductVariantMapper;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.core.service.ProductService;
import com.tuandang.ecommerce_api.core.service.ProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-variant")
public class ProductVariantsController {
    private final ProductVariantService productVariantService;
    private final ProductVariantMapper productVariantMapper;
    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> addProductVariant(
            @RequestBody ProductVariantDtoRequest request
    ) {
        productVariantService.create(productVariantMapper.toProductVariants(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> deleteProductVariant(
            @PathVariable UUID id
    ) {
        productVariantService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> updateProductVariant(
            @RequestBody ProductVariantDtoRequest request
    ) {
        productVariantService.update(productVariantMapper.toProductVariants(request));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public List<ProductVariants> getProductVariants(
            @PathVariable UUID id
    ) {
        return productService.getProductVariantsById(id);
    }
}
