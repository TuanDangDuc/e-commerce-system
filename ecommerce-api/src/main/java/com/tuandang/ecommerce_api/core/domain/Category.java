package com.tuandang.ecommerce_api.core.domain;

import lombok.Builder;

import java.util.UUID;

@Builder
public class Category {
    private UUID id;
    private String name;
}
