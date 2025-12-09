package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String type;
    @Column(
            columnDefinition = "TEXT"
    )
    private String thumbnailUrl;
    private float basePrice;

    @ManyToOne
    @JoinColumn(
            name = "merchantId"
    )
    @JsonBackReference
    private UsersEntity merchant;

    @OneToMany(
            mappedBy = "product"
    )
    @JsonManagedReference
    private List<ProductImagesEntity> images;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<ProductOptionEntity> options;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<ProductVariantsEntity> variants;

    @OneToMany(
            mappedBy = "product"
    )
    @JsonManagedReference
    private List<CategoryEntity> categories;

    @OneToMany(
            mappedBy = "product"
    )
    @JsonManagedReference
    private List<ReviewsEntity> reviews;
}
