package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.core.port.outgoing.AddressRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.AddressEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IAddressMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.AddressRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AddressRepositoryAdapter implements AddressRepositoryPort {
    private final AddressRepository addressRepository;
    private final IAddressMapper addressMapper;
    public AddressRepositoryAdapter(
            AddressRepository addressRepository,
            IAddressMapper addressMapper
    ) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public void save(
            Addresses address
    ){
        addressRepository.save(addressMapper.toAddressEntity(address));
    }

    @Override
    public void delete(
            UUID id
    ) {
        addressRepository.deleteById(id);
    }

    @Override
    public void update(
            Addresses addresses
    ) {
        addressRepository.update(addressMapper.toAddressEntity(addresses));
    }

    @Override
    public Addresses findById(UUID id){
        return addressMapper.toAddresses(
                addressRepository.findAddressEntitiesById(id)
        );
    }
}
