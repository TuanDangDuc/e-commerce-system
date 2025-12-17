package com.tuandang.ecommerce_api.api.dto.request.users;


public record ChangePasswordDtoRequest(
        String userName,
        String password
) {
}
