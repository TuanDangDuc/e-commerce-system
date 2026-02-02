package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.response.CartDtoResponse;
import com.tuandang.ecommerce_api.api.dto.response.CartItemDtoResponse;
import com.tuandang.ecommerce_api.api.mapper.CartItemMapper;
import com.tuandang.ecommerce_api.api.mapper.CartMapper;
import com.tuandang.ecommerce_api.core.service.CartItemService;
import com.tuandang.ecommerce_api.core.service.CartService;
import com.tuandang.ecommerce_api.core.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;
    private final CartItemMapper cartItemMapper;
    private final CartMapper cartMapper;
    private final UserServices userServices;

    @PostMapping("/{userId}")
    @PreAuthorize("hasRole('SELLER') or hasRole('BUYER')")
    public ResponseEntity<?> createCart(
            @PathVariable UUID userId
    ) {
        cartService.createCart(userId);
        return ResponseEntity.ok().build();
    }
    ///  get all cart item from cart
    @GetMapping("/{cartId}")
    @PreAuthorize("hasRole('SELLER') or hasRole('BUYER')")
    public List<CartItemDtoResponse> getCartItems(
            @PathVariable UUID cartId
    ) {
        return cartService.findAllCartItemById(cartId)
                .stream()
                .map(cartItemMapper::toCartItemDtoResponse)
                .toList();
    }

    // get total cost of cart
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('SELLER') or hasRole('BUYER')")
    public CartDtoResponse getCart(
            @PathVariable UUID userId
    ) {
        return cartMapper.toCartDtoResponse(cartService.getCart(userId));
    }
}
