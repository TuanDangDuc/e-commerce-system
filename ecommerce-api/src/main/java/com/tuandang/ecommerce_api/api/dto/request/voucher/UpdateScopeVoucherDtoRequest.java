package com.tuandang.ecommerce_api.api.dto.request.voucher;

import com.tuandang.ecommerce_api.core.Enum.Scope;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateScopeVoucherDtoRequest(
        @NotNull
        UUID id,
        @NotBlank
        Scope scope
) {
}
