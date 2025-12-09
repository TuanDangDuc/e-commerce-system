package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.VouchersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VouchersRepository extends JpaRepository<VouchersEntity, UUID> {
}
