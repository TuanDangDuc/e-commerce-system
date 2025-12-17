package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.api.dto.request.addresses.AddressDtoRequest;
import com.tuandang.ecommerce_api.api.mapper.AddressMapper;
import com.tuandang.ecommerce_api.core.exception.AccountNotFoundException;
import com.tuandang.ecommerce_api.core.port.outgoing.AddressRepositoryPort;
import com.tuandang.ecommerce_api.core.port.outgoing.UserRepositoryPort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepositoryPort addressRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;
    private final AddressMapper addressMapper;
    public AddressService(
            AddressRepositoryPort addressRepositoryPort,
            UserRepositoryPort userRepositoryPort,
            AddressMapper addressMapper
    ){
        this.addressRepositoryPort = addressRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.addressMapper = addressMapper;
    }

    public void save(
            AddressDtoRequest addressDtoRequest
    ){
        if (userRepositoryPort.findFirstUserNameById(addressDtoRequest.userId()) == null)
            throw new AccountNotFoundException(HttpStatus.NOT_FOUND.value(), "Account does not exist");
        else
            addressRepositoryPort.save(addressMapper.toAddress(addressDtoRequest));
    }
}
