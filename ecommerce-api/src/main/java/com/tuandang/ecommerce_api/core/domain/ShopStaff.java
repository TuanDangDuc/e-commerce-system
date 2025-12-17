package com.tuandang.ecommerce_api.core.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class ShopStaff {
    private UUID id;
    private String role;
    private boolean status;
    private LocalDateTime joinAt;
}
