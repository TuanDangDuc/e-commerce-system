package com.tuandang.ecommerce_api.infrastructure.persistence.repository;

import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountsEntity, UUID> {
}
