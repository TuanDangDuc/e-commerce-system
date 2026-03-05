package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.response.OrderItemDtoResponse;
import com.tuandang.ecommerce_api.api.mapper.OrderItemMapper;
import com.tuandang.ecommerce_api.core.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orderItem")
public class OrderItemController {
    private final OrderItemService orderItemService;
    private final OrderItemMapper orderItemMapper;

    @GetMapping("/{shopId}")
    public List<OrderItemDtoResponse> getOrderItem(
            @PathVariable UUID shopId
    ) {
        return orderItemService.getAllOrderByShopId(shopId)
                .stream()
                .map(orderItemMapper::toOrderItemDtoResponse)
                .toList();
    }


}
