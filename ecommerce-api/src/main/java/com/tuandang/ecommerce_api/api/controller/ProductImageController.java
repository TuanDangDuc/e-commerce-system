package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.productImage.AddImagesDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.ProductImageDtoResponse;
import com.tuandang.ecommerce_api.api.mapper.ProductImageMapper;
import com.tuandang.ecommerce_api.core.port.outgoing.ProductRepositoryPort;
import com.tuandang.ecommerce_api.core.service.ProductImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-image")
public class ProductImageController {
    private final ProductImageService productImageService;
    private final ProductImageMapper productImageMapper;

    // add image
    @PostMapping
    public ResponseEntity<?> addProductImage(
            @Valid @RequestBody AddImagesDtoRequest request
    ){
        productImageService.saveListImage(productImageMapper.toProductImages(request));
        return ResponseEntity.ok().build();
    }

    // get image
    @GetMapping("/{product-id}")
    public List<ProductImageDtoResponse> getImage(
            @PathVariable("product-id") UUID id
    ) {
        return productImageService.getAllImageOfProduct(id)
                .stream()
                .map(productImageMapper::productImageDtoResponses)
                .toList();
    }

    // delete image
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteImage(
            @PathVariable("id") UUID id
    ) {
        productImageService.deleteImageById(id);
        return ResponseEntity.ok().build();
    }
}
