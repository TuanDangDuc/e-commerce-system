package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class IAddressMapper {
    private final UsersRepository usersRepository;

    public AddressEntity toAddressEntity(
            Addresses address
    ){
        if  (address == null)
            throw new NullPointerException("address should not be null!");

        return AddressEntity.builder()
                .user(usersRepository.getReferenceById(address.getUserId()))
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
