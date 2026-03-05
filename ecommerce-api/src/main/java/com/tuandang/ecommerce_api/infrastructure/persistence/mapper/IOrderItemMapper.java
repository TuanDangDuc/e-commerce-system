package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.Enum.OrderStatus;
import com.tuandang.ecommerce_api.core.domain.OrderItem;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.OrderItemEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ProductVariantsEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.VouchersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.OrderItemRepository;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ProductVariantsRepository;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.VouchersRepository;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IOrderItemMapper {
    private final ProductVariantsRepository  productVariantsRepository;
    private final VouchersRepository vouchersRepository;

    public OrderItemEntity toOrderItemEntity(OrderItem orderItem) {
        var builder =  OrderItemEntity.builder()
                .id(orderItem.getId())
                .quantity(orderItem.getQuantity())
                .priceAtPurchase(orderItem.getPriceAtPurchase())
                .status(OrderStatus.PENDING)
                .trackingNumber(orderItem.getTrackingNumber())
                .shippingProvider(orderItem.getShippingProvider())
                .shopId(orderItem.getShopId())
                .productVariants(productVariantsRepository.getReferenceById(orderItem.getProductVariant().getId()));
        if (orderItem.getShopVouchers().getId() != null) {
            builder.shopVoucher(vouchersRepository.getReferenceById(orderItem.getShopVouchers().getId()));
        }
        return builder.build();
    }

    public OrderItem toOrderItem(OrderItemEntity orderItemEntity) {
        return OrderItem.builder()
                .id(orderItemEntity.getId())
                .quantity(orderItemEntity.getQuantity())
                .priceAtPurchase(orderItemEntity.getPriceAtPurchase())
                .status(orderItemEntity.getStatus())
                .trackingNumber(orderItemEntity.getTrackingNumber())
                .shippingProvider(orderItemEntity.getShippingProvider())
                .productVariant(ProductVariants.builder()
                        .id(orderItemEntity.getProductVariants().getId())
                        .options(orderItemEntity.getProductVariants().getOptions())
                        .product(Products.builder()
                                .name(orderItemEntity.getProductVariants().getProduct().getName())
                                .thumbnailUrl(orderItemEntity.getProductVariants().getProduct().getThumbnailUrl())
                                .description(orderItemEntity.getProductVariants().getProduct().getDescription())
                                .build())
                        .build())
                .build();
    }
}
