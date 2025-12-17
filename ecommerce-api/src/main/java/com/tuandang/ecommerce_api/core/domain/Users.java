package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.core.Enum.Role;
import com.tuandang.ecommerce_api.core.Enum.Sex;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Users extends Accounts{
    private Role role;
    private String fullName;
    private Sex sex;
    private LocalDateTime dateOfBirth;
    @Column(
            columnDefinition = "TEXT"
    )
    private String avatarUrl;

    @Fetch(FetchMode.SUBSELECT)
    private List<Addresses> addresses;

    @Fetch(FetchMode.SUBSELECT)
    private List<Shops> shops;

    @Fetch(FetchMode.SUBSELECT)
    private List<ShopStaff> shopStaffs;

    @Fetch(FetchMode.SUBSELECT)
    private List<Products> products;

    @Fetch(FetchMode.SUBSELECT)
    private List<Orders> orders;
}
