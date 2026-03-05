package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.productImage.AddImagesDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.products.AddProductDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.products.UpdateProductDtoRequest;
import com.tuandang.ecommerce_api.api.mapper.ProductMapper;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.core.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    // create new product
    @PostMapping
    public ResponseEntity<?> createProduct(
            @Valid @RequestBody AddProductDtoRequest request
    ) {
        productService.createProduct(productMapper.toAddProductDtoToProduct(request));
        return ResponseEntity.ok().build();
    }

    // delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(
            @PathVariable UUID id
    ) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

    // modify product
    @PutMapping
    public ResponseEntity<?> updateProduct(
        @Valid @RequestBody UpdateProductDtoRequest request
    ) {
        productService.updateProduct(productMapper.UpdateProductDtoToProduct(request));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{shopId}")
    public List<Products> getProduct(
            @PathVariable UUID shopId
    ) {
        return productService.findAllProductByShopId(shopId);
    }
}
