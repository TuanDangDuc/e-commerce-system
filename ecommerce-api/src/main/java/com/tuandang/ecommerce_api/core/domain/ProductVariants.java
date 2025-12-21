package com.tuandang.ecommerce_api.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductVariants {
    private UUID id;
    private float price;
    private Integer stock;
    private Map<String, String> options;
}
