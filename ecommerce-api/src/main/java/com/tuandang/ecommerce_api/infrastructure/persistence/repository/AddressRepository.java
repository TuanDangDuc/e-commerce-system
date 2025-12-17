package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
}
