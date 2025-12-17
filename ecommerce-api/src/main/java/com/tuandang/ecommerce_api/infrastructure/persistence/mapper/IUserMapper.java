package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.*;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import org.springframework.stereotype.Service;

@Service
public class IUserMapper {

    public UsersEntity toUsersEntity(Users user){
        return UsersEntity.builder()
                .role(user.getRole())
                .userName(user.getUserName())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }
    public Users toUsers(UsersEntity user){
        if (user == null)
            throw new NullPointerException("user should not be null!");

        return Users.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .role(user.getRole())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .sex(user.getSex())
                .dateOfBirth(user.getDateOfBirth())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }
    public Addresses toAddresses(AddressEntity addressEntity){
        return Addresses.builder()
                .userId(addressEntity.getId())
                .province(addressEntity.getProvince())
                .district(addressEntity.getDistrict())
                .ward(addressEntity.getWard())
                .city(addressEntity.getCity())
                .specificAddress(addressEntity.getSpecificAddress())
                .isDefault(addressEntity.isDefault())
                .type(addressEntity.getType())
                .phoneNumber(addressEntity.getPhoneNumber())
                .build();
    }
}
