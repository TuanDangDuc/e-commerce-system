package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID  )
    private UUID id;

    @OneToOne(
            cascade = CascadeType.MERGE
    )
    private UsersEntity cartOwner;
    private Float totalCost;
    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<CartItemEntity> cartItems;
}
