package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.api.dto.request.addresses.AddressDtoRequest;
import com.tuandang.ecommerce_api.api.mapper.AddressMapper;
import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.core.exception.AccountNotFoundException;
import com.tuandang.ecommerce_api.core.port.outgoing.AddressRepositoryPort;
import com.tuandang.ecommerce_api.core.port.outgoing.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepositoryPort addressRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final AddressMapper addressMapper;

    public void save(
            AddressDtoRequest addressDtoRequest
    ){
        if (userRepositoryPort.findFirstUserNameById(addressDtoRequest.userId()) == null)
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.value(), "Account does not exist");
        else
            addressRepositoryPort.save(addressMapper.toAddress(addressDtoRequest));
    }

    public void delete(UUID id) {
        addressRepositoryPort.delete(id);
    }

    public void update(
            Addresses addresses
    ){
        var base = addressRepositoryPort.findById(addresses.getId());
        if (base == null)
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.value(), "Invalid address");
        if (addresses.getProvince().isEmpty())
            addresses.setProvince(base.getProvince());
        if (addresses.getUserId() == null)
            addresses.setUserId(base.getUserId());
        if (addresses.getDistrict().isEmpty())
            addresses.setDistrict(base.getDistrict());
        if (addresses.getWard().isEmpty())
            addresses.setWard(base.getWard());
        if  (addresses.getCity().isEmpty())
            addresses.setCity(base.getCity());
        if (addresses.getCounty().isEmpty())
            addresses.setCounty(base.getCounty());
        if (addresses.getSpecificAddress().isEmpty())
            addresses.setSpecificAddress(base.getSpecificAddress());
        if (!addresses.isDefault())
            addresses.setDefault(base.isDefault());
        if (addresses.getType().isEmpty())
            addresses.setType(base.getType());
        if (addresses.getPhoneNumber().isEmpty())
            addresses.setPhoneNumber(base.getPhoneNumber());
        addressRepositoryPort.update(addresses);
    }
}