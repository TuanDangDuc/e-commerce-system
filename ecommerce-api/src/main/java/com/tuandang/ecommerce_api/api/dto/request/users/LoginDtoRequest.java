package com.tuandang.ecommerce_api.api.dto.request.users;

public record LoginDtoRequest(
        String userName,
        String password
) {
}
