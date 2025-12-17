package com.tuandang.ecommerce_api.api.dto.request.users;

import com.tuandang.ecommerce_api.core.Enum.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


public record RegisterUserDtoRequest(
        Role role,
        @NotEmpty
        String userName,
        @NotEmpty
        String password,
        @NotEmpty
        @Email
        String email
) {
}
