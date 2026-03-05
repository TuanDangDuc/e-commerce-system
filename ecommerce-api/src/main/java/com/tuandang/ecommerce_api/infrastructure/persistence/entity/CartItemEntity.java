package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"cart"})
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

    @OneToOne(cascade = CascadeType.MERGE)
    private ProductVariantsEntity productVariants;
}
