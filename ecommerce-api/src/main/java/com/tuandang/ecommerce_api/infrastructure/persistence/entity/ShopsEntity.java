package com.tuandang.ecommerce_api.infrastructure.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column( columnDefinition = "TEXT")
    private String description;
    private String status;
    @Column(columnDefinition = "TEXT")
    private String avatarUrl;
    private float ratingAverage;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    @JsonBackReference
    private UsersEntity owner;

    @OneToMany(mappedBy = "shop")
    @JsonManagedReference
    private List<ShopStaffEntity> shopStaffs;

}
