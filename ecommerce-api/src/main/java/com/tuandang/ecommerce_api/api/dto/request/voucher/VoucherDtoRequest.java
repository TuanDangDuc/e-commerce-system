package com.tuandang.ecommerce_api.api.dto.request.voucher;

import com.tuandang.ecommerce_api.core.Enum.Scope;
import com.tuandang.ecommerce_api.core.Enum.VoucherType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.LocalDateTime;
import java.util.UUID;

public record VoucherDtoRequest(
        @NotEmpty
        String name,
        @NotBlank
        String code,
        @NotNull
        VoucherType type,
        @NotNull
        Float value,
        Float maxDiscountAmount,
        @NotNull
        Float minOrderValue,
        @NotNull
        LocalDateTime startAt,
        @NotNull
        LocalDateTime endAt,
        @NotNull
        Integer usageLimit,
        Integer usedCount,
        Boolean isActive,
        @NotNull
        UUID shopId
) {
}
