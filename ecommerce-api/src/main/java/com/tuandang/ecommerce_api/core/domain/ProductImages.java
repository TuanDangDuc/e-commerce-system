package com.tuandang.ecommerce_api.core.domain;

import jakarta.persistence.Column;

import java.util.UUID;

public class ProductImages {
    private UUID id;

    @Column(
            columnDefinition = "TEXT"
    )
    private String url;

    private Integer ImageOrder;
}
