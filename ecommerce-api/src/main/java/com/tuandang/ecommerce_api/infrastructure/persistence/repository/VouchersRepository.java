package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.VouchersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface VouchersRepository extends JpaRepository<VouchersEntity, UUID> {


    @Modifying
    @Transactional
    @Query("update VouchersEntity a set a.isActive = :#{#onlyActiveVoucherEntity.isActive} where a.id = :#{#onlyActiveVoucherEntity.id}")
    public void setActiveVoucher(VouchersEntity onlyActiveVoucherEntity);

    @Modifying
    @Transactional
    @Query("update VouchersEntity a set a.scope = :#{#onlyScopeVoucherEntity.scope} where a.id = :#{#onlyScopeVoucherEntity.id}")
    public void setScopeVoucher(VouchersEntity onlyScopeVoucherEntity);

    @Modifying
    @Transactional
    @Query("update VouchersEntity a set a.type = :#{#onlyTypeVoucherEntity.type} where a.id = :#{#onlyTypeVoucherEntity.id}")
    public void setTypeVoucher(VouchersEntity onlyTypeVoucherEntity);
}
