package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.addresses.AddressDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.addresses.UpdateAddressDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.AddressesDtoResponse;
import com.tuandang.ecommerce_api.core.domain.Addresses;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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
                .isDefault(addresses.isDefault())
                .type(addresses.getType())
                .phoneNumber(addresses.getPhoneNumber())
                .build();
    }

    public Addresses toAddressWithoutUserId(
            @RequestBody UpdateAddressDtoRequest request
    ) {
        return Addresses.builder()
                .id(request.id())
                .userId(request.userId())
                .province(request.province())
                .district(request.district())
                .ward(request.ward())
                .city(request.city())
                .county(request.county())
                .specificAddress(request.specificAddress())
                .isDefault(request.isDefault())
                .type(request.type())
                .phoneNumber(request.phoneNumber())
                .build();
    }
}
