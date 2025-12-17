package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.core.Enum.Sex;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;
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
            "a.email = case when :email is not null then :email else a.email end, " +
            "a.fullName = case when :fullName is not null then :fullName else a.fullName end, " +
            "a.sex = case when :sex is not null then :sex else a.sex end, " +
            "a.dateOfBirth = case when :dateOfBirth is not null then cast(:dateOfBirth as timestamp) else a.dateOfBirth end, " +
            "a.avatarUrl = case when :avatarUrl is not null then :avatarUrl else a.avatarUrl end " +
            "where a.id = :id")
    public void updateUserById(
            @Param("id") UUID id,
            @Param("email") String email,
            @Param("fullName") String fullName,
            @Param("sex") Sex sex,
            @Param("dateOfBirth") LocalDateTime dateOfBirth,
            @Param("avatarUrl") String avatarUrl);

    @Query("select a.password from UsersEntity a where a.userName = :userName")
    public String findPasswordByUserName(String userName);

    @Query("select a.addresses from UsersEntity a where a.id = :id")
    public List<AddressEntity> findAddressById(UUID id);
}
