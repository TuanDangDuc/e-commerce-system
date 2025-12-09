package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.infrastructure.persistence.Enum.Scope;
import com.tuandang.ecommerce_api.infrastructure.persistence.Enum.VoucherType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Voucher {
    private UUID id;

    private UUID code;
    private VoucherType type;
    private float value;
    private float maxDiscountAmount;
    private float minOrderValue;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Integer usageLimit;
    private boolean isActive;
    private Scope scope;
}
