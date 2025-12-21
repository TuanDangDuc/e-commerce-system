package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
    @Query("select a from AddressEntity a where a.id = :id")
    public AddressEntity findAddressEntitiesById(UUID id);

    @Modifying
    @Transactional
    @Query("update AddressEntity a set a.province = :#{#addressEntity.province}," +
            "a.district = :#{#addressEntity.district}," +
            "a.ward =  :#{#addressEntity.ward}," +
            "a.city = :#{#addressEntity.city}," +
            "a.county = :#{#addressEntity.county}," +
            "a.specificAddress = :#{#addressEntity.specificAddress}," +
            "a.isDefault = :#{#addressEntity.isDefault()}," +
            "a.type = :#{#addressEntity.type}, " +
            "a.phoneNumber = :#{#addressEntity.phoneNumber}")
    public void update(AddressEntity addressEntity);
}
