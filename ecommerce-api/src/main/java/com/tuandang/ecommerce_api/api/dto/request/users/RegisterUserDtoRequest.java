package com.tuandang.ecommerce_api.api.dto.request.users;

import com.tuandang.ecommerce_api.core.Enum.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


public record RegisterUserDtoRequest(

        Role role,
        @NotBlank
        String userName,
        @NotBlank
        String password,
        @NotBlank
        @Email
        String email
) {
}
