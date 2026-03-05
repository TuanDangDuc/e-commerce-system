package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.order.OrderDtoRequest;
import com.tuandang.ecommerce_api.api.mapper.OrderMapper;
import com.tuandang.ecommerce_api.core.domain.Orders;
import com.tuandang.ecommerce_api.core.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<?> addOrder(
            @Valid @RequestBody OrderDtoRequest request
    ) {
        orderService.addOrder(orderMapper.toOrders(request));
        return ResponseEntity.ok().build();
    }

}
