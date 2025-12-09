package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private float priceAtPurchase;
    private String status;
    private UUID trackingNumber;
    private String shippingProvider;

    @OneToOne
    private ProductsEntity product;

    @OneToOne
    private ReviewsEntity review;

    @ManyToOne
    @JoinColumn(
            name = "orderId"
    )
    @JsonBackReference
    private OrdersEntity order;

    @OneToOne
    private VouchersEntity shopVoucher;



}
