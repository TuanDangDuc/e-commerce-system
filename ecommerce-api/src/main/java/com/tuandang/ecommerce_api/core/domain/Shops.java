package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.core.Enum.AccountStatus;
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
    private AccountStatus status;
    @Column(columnDefinition = "TEXT")
    private String avatarUrl;
    private Float ratingAverage;
    private Date createTime;
    private Users owner;
    private List<Products> products;
    private List<ShopStaff> shopStaffs;
    private List<Vouchers> vouchers;
}
