package com.tuandang.ecommerce_api.infrastructure.persistence.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tuandang.ecommerce_api.core.Enum.Role;
import com.tuandang.ecommerce_api.core.Enum.Sex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
public class UsersEntity extends AccountsEntity {

    private Role role;
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
    private Set<AddressEntity> addresses;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private Set<ShopsEntity> shops;

    @OneToMany(
            mappedBy = "staff"
    )
    @JsonManagedReference
    private Set<ShopStaffEntity> shopStaffs;

    @OneToMany(
            mappedBy = "merchant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private Set<ProductsEntity> products;

    @OneToMany(
            mappedBy = "user"
    )
    @JsonManagedReference
    //@Fetch(FetchMode.SUBSELECT)
    private Set<OrdersEntity> orders;

    @OneToOne(
            mappedBy = "cartOwner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private CartsEntity carts;
}
