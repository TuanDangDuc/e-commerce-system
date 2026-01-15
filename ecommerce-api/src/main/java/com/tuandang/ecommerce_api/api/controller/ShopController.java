package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.shop.ShopDtoRequest;
import com.tuandang.ecommerce_api.api.mapper.ShopMapper;
import com.tuandang.ecommerce_api.core.domain.Shops;
import com.tuandang.ecommerce_api.core.service.ShopService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop")
public class ShopController {
    private final ShopService shopService;
    private final ShopMapper shopMapper;

    @PostMapping
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> createShop(
            @RequestBody ShopDtoRequest request
    ) {
        shopService.create(shopMapper.toShop(request));
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public Shops getShop (
            @PathVariable UUID id
    ) {
      return shopService.getShopById(id);
    }

    @PutMapping()
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> updateShop(
        @RequestBody ShopDtoRequest request
    ) {
        shopService.modifyShop(shopMapper.toShop(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> deleteShop(
            @PathVariable UUID id
    ) {
        shopService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
