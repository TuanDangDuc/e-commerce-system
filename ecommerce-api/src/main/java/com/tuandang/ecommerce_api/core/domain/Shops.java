package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.ShopStaffEntity;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Shops {
    private UUID id;
    private String name;
    @Column( columnDefinition = "TEXT")
    private String description;
    private String status;
    @Column(columnDefinition = "TEXT")
    private String avatarUrl;
    private Float ratingAverage;
    private Date createTime;
    private Users owner;
    private List<ShopStaff> shopStaffs;
}
