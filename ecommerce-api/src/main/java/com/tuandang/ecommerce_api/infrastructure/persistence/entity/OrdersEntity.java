package com.tuandang.ecommerce_api.infrastructure.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tuandang.ecommerce_api.core.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

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
    private String orderCode;
    private String recipientName;
    private String recipientPhone;
    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "shippingAddressId"
    )
    @JsonBackReference
    private AddressEntity shippingAddress;
    @Column(columnDefinition = "TEXT")
    private String note;
    private Float subtotal;
    private Float shippingFee;
    private Float discountAmount;
    private Float totalAmount;
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime canceledAt;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

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

    @ManyToOne()
    @JoinColumn(
            name = "platformVoucherId"
    )
    @JsonBackReference
    private VouchersEntity platformVoucher;

    @ManyToOne()
    @JoinColumn(
            name = "shippingVoucherId"
    )
    @JsonBackReference
    private VouchersEntity shippingVoucher;

}
