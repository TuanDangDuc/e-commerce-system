package com.tuandang.ecommerce_api.api.dto.response;

import com.tuandang.ecommerce_api.core.Enum.Role;
import com.tuandang.ecommerce_api.core.Enum.Sex;
import com.tuandang.ecommerce_api.core.domain.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record UserDtoResponse(
    UUID id,
    String userName,
    Role role,
    String email,
    String fullName,
    Sex sex,
    LocalDateTime dateOfBirth,
    String avatarUrl
) {
}
