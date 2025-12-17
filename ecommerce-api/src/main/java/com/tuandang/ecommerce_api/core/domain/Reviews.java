package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ReviewImagesEntity;
import jakarta.persistence.Column;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public class Reviews {
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
    private List<ReviewImages> reviewImages;
}
