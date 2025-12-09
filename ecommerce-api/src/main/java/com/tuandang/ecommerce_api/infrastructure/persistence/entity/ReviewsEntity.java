package com.tuandang.ecommerce_api.infrastructure.persistence.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private float rating;
    @Column(
            columnDefinition = "TEXT"
    )
    private String comment;
    @Column(
            columnDefinition = "TEXT"
    )
    private String shopReply;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(
            name = "productId"
    )
    @JsonBackReference
    private ProductsEntity product;

    @OneToMany(
            mappedBy = "review",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<ReviewImagesEntity> reviewImages;
}
