package com.tuandang.ecommerce_api.api.dto.request.voucher;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

public record UpdateActiveVoucherDtoRequest (
        @NotNull
        UUID id,
        @NotNull
        Boolean isActive
) {
}
