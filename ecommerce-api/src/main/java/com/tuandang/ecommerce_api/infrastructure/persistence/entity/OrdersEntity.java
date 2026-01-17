package com.tuandang.ecommerce_api.infrastructure.persistence.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID orderCode;
    private String recipientName;
    private String recipientPhone;
    @OneToOne
    private AddressEntity shippingAddress;
    @Column(columnDefinition = "TEXT")
    private String note;
    private float subtotal;
    private float shippingFee;
    private float discountAmount;
    private float totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime canceledAt;
    private String status;

    @ManyToOne
    @JoinColumn(
            name =  "orderer"
    )
    private UsersEntity user;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<OrderItemEntity> orderItems;

    @OneToOne
    private VouchersEntity platformVoucher;

    @OneToOne
    private VouchersEntity shippingVoucher;

}
