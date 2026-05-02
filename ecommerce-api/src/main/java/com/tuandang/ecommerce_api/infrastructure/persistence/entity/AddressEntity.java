package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String province;
    private String district;
    private String ward;
    private String city;
    private String county;
    private String specificAddress;
    private Boolean isDefault;
    private String type;
    private String phoneNumber;

    @ManyToOne()
    @JoinColumn(
            name = "userId"
    )
    @JsonBackReference
    private UsersEntity user;

    @OneToMany(
            mappedBy = "shippingAddress",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<OrdersEntity> orders;
}
