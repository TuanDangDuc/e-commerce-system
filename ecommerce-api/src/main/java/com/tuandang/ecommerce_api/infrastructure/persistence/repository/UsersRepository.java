package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.core.Enum.Sex;
import com.tuandang.ecommerce_api.core.domain.Carts;
import com.tuandang.ecommerce_api.core.domain.Products;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<UsersEntity, UUID> {
    @Query("select a.id from UsersEntity a where a.userName = :userName")
    public UUID findIdByUserName(String userName);

    @Modifying
    @Transactional
    @Query("update UsersEntity a set a.password = :password where a.userName = :userName")
    public void changePasswordByUserName(String userName, String password);

    @Query("select a.userName from UsersEntity a where a.id = :id")
    public String findFirstUserNameById(UUID id);

    List<UsersEntity> findUsersEntitiesByUserName(String userName);

    List<UsersEntity> userName(String userName);

    @Query("select a from UsersEntity a where a.userName = :userName")
    public UsersEntity findFirstUserNameByUserName(String userName);

    @Modifying
    @Transactional
    @Query("update UsersEntity a set " +
            "a.email =  :email , " +
            "a.fullName = :fullName,  " +
            "a.sex = :sex, " +
            "a.dateOfBirth =  cast(:dateOfBirth as timestamp), " +
            "a.avatarUrl = :avatarUrl " +
            "where a.id = :id")
    public void updateUserById(
            @Param("id") UUID id,
            @Param("email") String email,
            @Param("fullName") String fullName,
            @Param("sex") Sex sex,
            @Param("dateOfBirth") LocalDateTime dateOfBirth,
            @Param("avatarUrl") String avatarUrl);

    @Query("select a.password from UsersEntity a where a.userName = :userName")
    public Optional<String> findPasswordByUserName(String userName);

    @Query("select a.addresses from UsersEntity a where a.id = :id")
    public List<AddressEntity> findAddressById(UUID id);

    public UsersEntity findUsersEntitiesById(UUID id);

    @Query("select a.role from UsersEntity a where a.userName = :userName")
    public String findRoleByUserName(String userName);

    public UsersEntity findUsersEntitiesByEmail(String email);

    @Query("select a.products from UsersEntity a where a.id = :userId")
    public List<ProductsEntity> findProductByUserId(UUID userId);

    @Query("select a.carts from UsersEntity a where a.id = :userId")
    public CartsEntity findCartByUserId(UUID userId);

    @Query("select a.vouchers from UsersEntity a where a.id = :userId")
    public List<VouchersEntity> getVoucherByUserId(UUID userId);
}
