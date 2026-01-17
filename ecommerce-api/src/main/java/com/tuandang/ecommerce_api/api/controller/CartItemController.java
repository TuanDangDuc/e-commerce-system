package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.CartItem.CartItemDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.CartItem.UpdateCartItemDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.CartItemDtoResponse;
import com.tuandang.ecommerce_api.api.mapper.CartItemMapper;
import com.tuandang.ecommerce_api.core.domain.CartItem;
import com.tuandang.ecommerce_api.core.service.CartItemService;
import com.tuandang.ecommerce_api.core.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cart-item")
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;
    private final CartItemMapper cartItemMapper;

    @PostMapping
    @PreAuthorize("hasRole('SELLER') or hasRole('BUYER')")
    public ResponseEntity<?> save(
            @RequestBody CartItemDtoRequest request
    ) {
        cartItemService.save(cartItemMapper.toCartItem(request));
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @PreAuthorize("hasRole('SELLER') or hasRole('BUYER')")
    public ResponseEntity<?> updateQuantity(
            @RequestBody UpdateCartItemDtoRequest request
    ) {
        cartItemService.updateQuantityById(cartItemMapper.toUpdateQuantityCartItem(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SELLER') or hasRole('BUYER')")
    public ResponseEntity<?> delete(
            @PathVariable UUID id
    ) {
        cartItemService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
