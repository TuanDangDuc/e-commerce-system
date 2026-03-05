package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.orderItem.OrderItemDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.OrderItemDtoResponse;
import com.tuandang.ecommerce_api.core.domain.OrderItem;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItem toOrderItem(OrderItemDtoRequest request) {
        return OrderItem.builder()
                .quantity(request.quantity())
                .priceAtPurchase(request.priceAtPurchase())
                .trackingNumber(request.trackingNumber())
                .shippingProvider(request.shippingProvider())
                .shopId(request.shopId())
                .productVariant(ProductVariants.builder()
                        .id(request.productVariantId())
                        .build())
                .shopVouchers(Vouchers.builder()
                        .id(request.shopVoucherID())
                        .build())
                .build();
    }

    public OrderItemDtoResponse toOrderItemDtoResponse(
            OrderItem orderItem
    ) {
        return OrderItemDtoResponse.builder()
                .id(orderItem.getId())
                .quantity(orderItem.getQuantity())
                .priceAtPurchase(orderItem.getPriceAtPurchase())
                .status(orderItem.getStatus())
                .trackingNumber(orderItem.getTrackingNumber())
                .shippingProvider(orderItem.getShippingProvider())
                .productVariantsId(orderItem.getProductVariant().getId())
                .options(orderItem.getProductVariant().getOptions())
                .name(orderItem.getProductVariant().getProduct().getName())
                .thumbnailUrl(orderItem.getProductVariant().getProduct().getThumbnailUrl())
                .description(orderItem.getProductVariant().getProduct().getDescription())
                .build();
    }
}
