package com.tuandang.ecommerce_api.api.dto.request.users;

import jakarta.validation.constraints.NotBlank;

public record LoginDtoRequest(
        @NotBlank
        String userName,
        @NotBlank
        String password
) {
}
