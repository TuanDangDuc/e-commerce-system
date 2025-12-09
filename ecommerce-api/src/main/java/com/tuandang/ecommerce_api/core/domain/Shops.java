package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ShopStaffEntity;
import jakarta.persistence.Column;

import java.util.List;
import java.util.UUID;

public class Shops {
    private UUID id;
    private String name;
    @Column( columnDefinition = "TEXT")
    private String description;
    private String status;
    @Column(columnDefinition = "TEXT")
    private String avatarUrl;
    private float ratingAverage;
    private List<ShopStaff> shopStaffs;
}
