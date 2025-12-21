package com.tuandang.ecommerce_api.api.dto.request.users;

import com.tuandang.ecommerce_api.core.Enum.Sex;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateUserDtoRequest(
        UUID id,
        String email,
        String fullName,
        Sex sex,
        LocalDateTime dateOfBirth,
        String avatarUrl
) {
}
