package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import org.springframework.stereotype.Component;


@Component
public class IAddressMapper {
    public AddressEntity toAddressEntity(Addresses address){
        var user = UsersEntity.builder()
                .id(address.getUserId())
                .build();
        return AddressEntity.builder()
                .user(user)
                .province(address.getProvince())
                .district(address.getDistrict())
                .ward(address.getWard())
                .city(address.getCity())
                .county(address.getCounty())
                .specificAddress(address.getSpecificAddress())
                .isDefault(address.getIsDefault())
                .type(address.getType())
                .phoneNumber(address.getPhoneNumber())
                .build();
    }
}
