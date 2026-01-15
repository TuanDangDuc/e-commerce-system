package com.tuandang.ecommerce_api.infrastructure.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;
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
    private String status;
    @Column(columnDefinition = "TEXT")
    private String avatarUrl;
    private Float ratingAverage;
    @CreationTimestamp
    @Column(updatable = false)
    private Date createTime;
    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "ownerId")
    @JsonBackReference
    private UsersEntity owner;

    @OneToMany(mappedBy = "shop")
    @JsonManagedReference
    private List<ShopStaffEntity> shopStaffs;

}
