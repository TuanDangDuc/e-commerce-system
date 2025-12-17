package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopStaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String role;
    private Boolean status;
    private LocalDateTime joinAt;

    @ManyToOne()
    @JoinColumn(
            name = "staffId",
            nullable = false
    )
    @JsonBackReference
    private UsersEntity staff;

    @ManyToOne
    @JoinColumn(
            name = "shopId",
            nullable = false
    )
    @JsonBackReference
    ShopsEntity shop;


}
