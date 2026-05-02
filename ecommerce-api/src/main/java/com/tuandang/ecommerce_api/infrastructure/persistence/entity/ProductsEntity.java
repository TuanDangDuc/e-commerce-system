package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tuandang.ecommerce_api.core.Enum.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.engine.spi.CascadeStyle;
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
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(
            columnDefinition = "TEXT"
    )
    private String thumbnailUrl;
    private Float basePrice;
    @Column(
            columnDefinition = "TEXT"
    )
    private String description;
    private Float ratingAverage;

    @ManyToOne()
    @JoinColumn(
            name = "shopId"
    )
    @JsonBackReference
    private ShopsEntity shop;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    @OrderColumn(name = "imageOrder")
    private List<ProductImagesEntity> images;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<ProductVariantsEntity> variants;

    @ManyToMany(
            cascade = CascadeType.MERGE
    )
    @JoinTable(
            name = "CategoryProduct",
            joinColumns = {
                @JoinColumn(name = "productId",
                referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "categoryId",
                    referencedColumnName = "id")
            }
    )
    private List<CategoryEntity> categories;



}
