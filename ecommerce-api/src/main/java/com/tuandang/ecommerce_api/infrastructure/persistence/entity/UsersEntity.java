package com.tuandang.ecommerce_api.infrastructure.persistence.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tuandang.ecommerce_api.infrastructure.persistence.Enum.Sex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
public class UsersEntity extends AccountsEntity {

    private String fullName;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private LocalDateTime dateOfBirth;

    @Column(
            columnDefinition = "TEXT"
    )
    private String avatarUrl;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<AddressEntity> addresses;

    @OneToMany(
            mappedBy = "owner"
    )
    @JsonManagedReference
    private List<ShopsEntity> shops;

    @OneToMany(
            mappedBy = "staff"
    )
    @JsonManagedReference
    private List<ShopStaffEntity> shopStaffs;

    @OneToMany(
            mappedBy = "merchant"
    )
    @JsonManagedReference
    private List<ProductsEntity> products;

    @OneToMany(
            mappedBy = "user"
    )
    @JsonManagedReference
    private List<OrdersEntity> orders;
}
