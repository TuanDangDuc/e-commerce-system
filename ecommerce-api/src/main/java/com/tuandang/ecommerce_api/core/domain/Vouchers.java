package com.tuandang.ecommerce_api.core.domain;

import com.tuandang.ecommerce_api.core.Enum.Scope;
import com.tuandang.ecommerce_api.core.Enum.VoucherType;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class Vouchers {
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
