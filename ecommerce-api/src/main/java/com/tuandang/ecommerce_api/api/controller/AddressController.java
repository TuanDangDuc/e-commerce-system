package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.addresses.AddressDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.addresses.UpdateAddressDtoRequest;
import com.tuandang.ecommerce_api.api.mapper.AddressMapper;
import com.tuandang.ecommerce_api.core.domain.Addresses;
import com.tuandang.ecommerce_api.core.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;
    public AddressController(
            AddressService addressService,
            AddressMapper addressMapper
    ) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }
    // create address
    @PostMapping
    public ResponseEntity<?> createAddress(
           @Valid @RequestBody AddressDtoRequest addressDtoRequest
    ){
        addressService.save(addressDtoRequest);
        return ResponseEntity.ok().build();
    }

    // delete address
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(
            @PathVariable UUID id
    ) {
        addressService.delete(id);
        return ResponseEntity.ok().build();
    }

    // modify address // dang bug
    @PutMapping
    public ResponseEntity<?> updateAddress(
         @RequestBody UpdateAddressDtoRequest request
    ) {
        addressService.update(addressMapper.toAddressWithoutUserId(request));
        return ResponseEntity.ok().build();
    }
    // get address co ben userController roi
}
