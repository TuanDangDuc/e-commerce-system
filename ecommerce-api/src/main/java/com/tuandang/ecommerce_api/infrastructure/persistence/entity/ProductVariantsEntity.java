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
import org.yaml.snakeyaml.DumperOptions;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVariantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private float price;
    private Integer stock;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> options;

    @ManyToOne()
    @JoinColumn(
            name = "productId"
    )
    @JsonBackReference
    private ProductsEntity product;

    @OneToMany(
            mappedBy = "productVariant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<ReviewsEntity> reviews;

    @OneToMany(
            mappedBy = "productVariants"
    )
    @JsonManagedReference
    private List<OrderItemEntity> orderItems;
}
