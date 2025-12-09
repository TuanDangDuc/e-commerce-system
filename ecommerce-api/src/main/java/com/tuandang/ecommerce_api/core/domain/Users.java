package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.Enum.Sex;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.*;
import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.List;

public class Users {
    private String fullName;
    private Sex sex;
    private LocalDateTime dateOfBirth;
    @Column(
            columnDefinition = "TEXT"
    )
    private String avatarUrl;
    private List<Address> addresses;
    private List<Shops> shops;
    private List<ShopStaff> shopStaffs;
    private List<Product> products;
    private List<Order> orders;
}
