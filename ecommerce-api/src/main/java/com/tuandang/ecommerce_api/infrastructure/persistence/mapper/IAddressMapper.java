package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import org.springframework.stereotype.Component;


@Component
public class IAddressMapper {
    public AddressEntity toAddressEntity(
            Addresses address
    ){
        if  (address == null)
            throw new NullPointerException("address should not be null!");
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
                .isDefault(address.isDefault())
                .type(address.getType())
                .phoneNumber(address.getPhoneNumber())
                .build();
    }

    public Addresses toAddresses(
            AddressEntity address
    ){
        if (address == null)
            throw new NullPointerException("Address should not be null");
        return Addresses.builder()
                .id(address.getId())
                .userId(address.getUser().getId())
                .province(address.getProvince())
                .district(address.getDistrict())
                .ward(address.getWard())
                .city(address.getCity())
                .county(address.getCounty())
                .specificAddress(address.getSpecificAddress())
                .isDefault(address.isDefault())
                .type(address.getType())
                .phoneNumber(address.getPhoneNumber())
                .build();
    }
}
