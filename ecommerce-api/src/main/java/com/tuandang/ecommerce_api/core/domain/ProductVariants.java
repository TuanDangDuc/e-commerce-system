package com.tuandang.ecommerce_api.core.domain;

import lombok.Builder;

import java.util.Map;
import java.util.UUID;

@Builder
public class ProductVariants {
    private UUID id;
    private float price;
    private Integer stock;
    private Map<String, String> options;
}
