package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.addresses.AddressDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.users.RegisterUserDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.users.UpdateUserDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.UserDtoResponse;
import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.core.domain.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public Users toUsers(
            RegisterUserDtoRequest registerUserDtoRequest
    ){
        return Users.builder()
                .role(registerUserDtoRequest.role())
                .userName(registerUserDtoRequest.userName())
                .password(registerUserDtoRequest.password())
                .email(registerUserDtoRequest.email())
                .build();

    }
    public Users toUsersUpdate(
            UpdateUserDtoRequest updateUserDtoRequest
    ){
        return Users.builder()
                .id(updateUserDtoRequest.id())
                .email(updateUserDtoRequest.email())
                .fullName(updateUserDtoRequest.fullName())
                .sex(updateUserDtoRequest.sex())
                .dateOfBirth(updateUserDtoRequest.dateOfBirth())
                .avatarUrl(updateUserDtoRequest.avatarUrl())
                .build();
    }
    public Addresses toAddress(AddressDtoRequest address){
        return Addresses.builder()
                .province(address.province())
                .district(address.district())
                .ward(address.ward())
                .city(address.city())
                .county(address.county())
                .specificAddress(address.specificAddress())
                .isDefault(address.isDefault())
                .type(address.type())
                .phoneNumber(address.phoneNumber())
                .build();
    }
    public UserDtoResponse toUserDtoResponse(Users user ){
        return UserDtoResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .role(user.getRole())
                .sex(user.getSex())
                .dateOfBirth(user.getDateOfBirth())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }
}
