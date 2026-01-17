package com.tuandang.ecommerce_api.api.dto.response;

import com.tuandang.ecommerce_api.core.Enum.Scope;
import com.tuandang.ecommerce_api.core.Enum.VoucherType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record VoucherDtoResponse(
        UUID id,
        String code,
        VoucherType type,
        Float value,
        Float maxDiscountAmount,
        Float minOrderValue,
        LocalDateTime startAt,
        LocalDateTime endAt,
        Integer usageLimit,
        Integer usedCount,
        Boolean isActive,
        Scope scope
) {
}
