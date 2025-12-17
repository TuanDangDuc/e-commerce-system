package com.tuandang.ecommerce_api.core.domain;

import jakarta.persistence.Column;
import lombok.Builder;

import java.util.UUID;

@Builder
public class ProductImages {
    private UUID id;

    @Column(
            columnDefinition = "TEXT"
    )
    private String url;

    private Integer imageOrder;
}
