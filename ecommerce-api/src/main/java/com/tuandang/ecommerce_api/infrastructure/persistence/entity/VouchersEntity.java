package com.tuandang.ecommerce_api.infrastructure.persistence.entity;

import com.tuandang.ecommerce_api.core.Enum.Scope;
import com.tuandang.ecommerce_api.core.Enum.VoucherType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VouchersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID code;
    private VoucherType  type;
    private float value;
    private float maxDiscountAmount;
    private float minOrderValue;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Integer usageLimit;
    private boolean isActive;
    private Scope scope;


}
