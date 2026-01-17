package com.tuandang.ecommerce_api.api.dto.request.voucher;

import com.tuandang.ecommerce_api.core.Enum.Type;
import com.tuandang.ecommerce_api.core.Enum.VoucherType;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateTypeVoucherDtoRequest(
        @NotNull
        UUID id,
        @NotNull
        VoucherType type
) {
}
