package com.tuandang.ecommerce_api.infrastructure.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tuandang.ecommerce_api.core.Enum.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShopsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column( columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @Column(columnDefinition = "TEXT")
    private String avatarUrl;
    private Float ratingAverage;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createTime;
    @ManyToOne()
    @JoinColumn(
            name = "ownerId"
    )
    @JsonBackReference
    private UsersEntity owner;

    @OneToMany(mappedBy = "shop")
    @JsonManagedReference
    private List<ShopStaffEntity> shopStaffs;

    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private Set<ProductsEntity> products;

    @OneToMany(
            mappedBy = "shops",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<VouchersEntity> vouchers;
}
