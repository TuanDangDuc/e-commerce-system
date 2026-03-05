package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tuandang.ecommerce_api.core.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer quantity;
    private Float priceAtPurchase;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private UUID trackingNumber;
    private String shippingProvider;
    private UUID shopId;
    @ManyToOne()
    @JoinColumn(
            name = "productVariantsId"
    )
    @JsonBackReference
    private ProductVariantsEntity productVariants;

    @OneToOne
    private ReviewsEntity review;

    @ManyToOne
    @JoinColumn(
            name = "orderId"
    )
    @JsonBackReference
    private OrdersEntity order;

    @ManyToOne()
    @JoinColumn(
            name = "shopVoucherId"
    )
    @JsonBackReference
    private VouchersEntity shopVoucher;
}
