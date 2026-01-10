package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.productVariants.AddProductVariantDtoRequest;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-variant")
public class ProductVariantsController {

//    @PostMapping
//    public ResponseEntity<String> addProductVariant(
//            @RequestBody AddProductVariantDtoRequest request
//    ) {
//
//    }
}
