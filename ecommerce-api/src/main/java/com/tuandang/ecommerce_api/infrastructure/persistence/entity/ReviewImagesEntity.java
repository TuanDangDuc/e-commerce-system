package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(
            columnDefinition = "TEXT"
    )
    private String url;
    private Integer imageOrder;

    @ManyToOne
    @JoinColumn(
            name = "reviewId"
    )
    @JsonBackReference
    private ReviewsEntity review;
}
