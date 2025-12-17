package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.addresses.AddressDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.AddressesDtoResponse;
import com.tuandang.ecommerce_api.core.domain.Addresses;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Addresses toAddress(
            AddressDtoRequest addressDtoRequest
    ){
        return Addresses.builder()
                .userId(addressDtoRequest.userId())
                .province(addressDtoRequest.province())
                .district(addressDtoRequest.district())
                .ward(addressDtoRequest.ward())
                .city(addressDtoRequest.city())
                .county(addressDtoRequest.county())
                .specificAddress(addressDtoRequest.specificAddress())
                .isDefault(addressDtoRequest.isDefault())
                .type(addressDtoRequest.type())
                .phoneNumber(addressDtoRequest.phoneNumber())
                .build();
    }
    public AddressesDtoResponse toAddressDtoResponse(
            Addresses addresses
    ){
        return AddressesDtoResponse.builder()
                .province(addresses.getProvince())
                .district(addresses.getDistrict())
                .ward(addresses.getWard())
                .city(addresses.getCity())
                .county(addresses.getCounty())
                .specificAddress(addresses.getSpecificAddress())
                .isDefault(addresses.getIsDefault())
                .type(addresses.getType())
                .phoneNumber(addresses.getPhoneNumber())
                .build();
    }
}
