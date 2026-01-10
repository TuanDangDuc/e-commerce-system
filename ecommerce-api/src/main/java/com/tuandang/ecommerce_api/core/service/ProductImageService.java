package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.api.mapper.ProductImageMapper;
import com.tuandang.ecommerce_api.core.domain.ProductImages;
import com.tuandang.ecommerce_api.core.port.outgoing.ProductImagesRepositoryPort;
import com.tuandang.ecommerce_api.core.port.outgoing.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductImageService {
    private final ProductImagesRepositoryPort productImagesRepositoryPort;

    public void saveListImage(List<ProductImages> productImages){
        productImagesRepositoryPort.save(productImages);
    }

    public List<ProductImages> getAllImageOfProduct(
            UUID id
    ){
        return productImagesRepositoryPort.getAllImageOfProduct(id);
    }

    public void deleteImageById(
            UUID id
    ){
        productImagesRepositoryPort.deleteById(id);
    }
}
