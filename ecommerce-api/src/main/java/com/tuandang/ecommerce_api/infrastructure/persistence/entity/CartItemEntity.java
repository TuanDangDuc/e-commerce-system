package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer quantity;
    private float price;

    @ManyToOne
    @JoinColumn(
            name = "cartId"
    )
    @JsonBackReference
    private CartsEntity cart;

    @OneToOne(
            cascade = CascadeType.MERGE
    )
    private ProductVariantsEntity productVariants;
}
