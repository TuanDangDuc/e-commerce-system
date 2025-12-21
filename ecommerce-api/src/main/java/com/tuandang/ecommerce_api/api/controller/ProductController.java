package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.productImage.AddImagesDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.products.AddProductDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.products.UpdateProductDtoRequest;
import com.tuandang.ecommerce_api.api.mapper.ProductMapper;
import com.tuandang.ecommerce_api.core.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;
    public ProductController(
            ProductService productService,
            ProductMapper productMapper
    ) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    // create new product
    @PostMapping
    public ResponseEntity<?> createProduct(
            @RequestBody AddProductDtoRequest request
    ) {
        productService.createProduct(productMapper.AddProductDtoToProduct(request));
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
        @RequestBody UpdateProductDtoRequest request
    ) {
        productService.updateProduct(productMapper.UpdateProductDtoToProduct(request));
        return ResponseEntity.ok().build();
    }
}
