package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.voucher.*;
import com.tuandang.ecommerce_api.api.dto.response.VoucherDtoResponse;
import com.tuandang.ecommerce_api.api.mapper.VoucherMapper;
import com.tuandang.ecommerce_api.core.service.UserServices;
import com.tuandang.ecommerce_api.core.service.VoucherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.management.InvalidAttributeValueException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voucher")
public class VoucherController {
    private final VoucherService voucherService;
    private final VoucherMapper voucherMapper;

    @PostMapping
    @PreAuthorize("hasRole('SELLER') and hasRole('ADMIN')")
    public ResponseEntity<?> createVoucher(
            @Valid @RequestBody VoucherDtoRequest request
    ) {
        voucherService.save(voucherMapper.toVoucher(request));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/active")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> updateActiveVoucher(
            @Valid @RequestBody UpdateActiveVoucherDtoRequest request
    ) {
        voucherService.updateActiveVoucher(voucherMapper.toVoucher(request));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/scope")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> updateVoucherScope(
            @Valid @RequestBody UpdateScopeVoucherDtoRequest request
    ) {
        voucherService.updateScopeVoucher(voucherMapper.toVoucher(request));
        return  ResponseEntity.ok().build();
    }

    @PatchMapping("/type")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> updateTypeVoucher(
            @Valid @RequestBody UpdateTypeVoucherDtoRequest request
    ) {
        voucherService.updateTypeVoucher(voucherMapper.toVoucher(request));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{shopId}")
    @PreAuthorize("hasRole('SELLER')")
    public List<VoucherDtoResponse> getVoucher(
            @PathVariable UUID shopId
    ) {
        return voucherService.getAllVoucherByShopId(shopId)
                .stream()
                .map(voucherMapper::toVoucherDtoResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> deleteVoucher(
            @PathVariable UUID id
    ) {
        voucherService.deleteVoucherById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/usage/{id}")
    public ResponseEntity<?> updateVoucherUsage(
            @PathVariable UUID id
    ) {
        voucherService.updateVoucherUsage(id);
        return ResponseEntity.ok().build();
    }

    // check voucher
    @PostMapping("/shop")
    public Float checkShopVoucher(
        @RequestBody checkShopVoucherDtoRequest request
    ) {
        return voucherService.calculate(request.shopId(), request.code(), request.productVariantId(), request.quantity());
    }


}
