package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.addresses.AddressDtoRequest;
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
    public AddressController(
            AddressService addressService
    ) {
        this.addressService = addressService;
    }
    // create address
    @PostMapping
    public ResponseEntity<Void> createAddress(
           @Valid @RequestBody AddressDtoRequest addressDtoRequest
    ){
        addressService.save(addressDtoRequest);
        return ResponseEntity.ok().build();
    }

}
