package com.tuandang.ecommerce_api.api.controller;

import com.tuandang.ecommerce_api.api.dto.request.voucher.UpdateActiveVoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.voucher.UpdateScopeVoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.voucher.UpdateTypeVoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.voucher.VoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.VoucherDtoResponse;
import com.tuandang.ecommerce_api.api.mapper.VoucherMapper;
import com.tuandang.ecommerce_api.core.service.UserServices;
import com.tuandang.ecommerce_api.core.service.VoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voucher")
public class VoucherController {
    private final VoucherService voucherService;
    private final VoucherMapper voucherMapper;
    private final UserServices userServices;

    @PostMapping
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> createVoucher(
            @RequestBody VoucherDtoRequest request
    ) {
        voucherService.save(voucherMapper.toVoucher(request));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/active")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> updateActiveVoucher(
            @RequestBody UpdateActiveVoucherDtoRequest request
    ) {
        voucherService.updateActiveVoucher(voucherMapper.toVoucher(request));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/scope")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> updateVoucherScope(
            @RequestBody UpdateScopeVoucherDtoRequest request
    ) {
        voucherService.updateScopeVoucher(voucherMapper.toVoucher(request));
        return  ResponseEntity.ok().build();
    }

    @PatchMapping("/type")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> updateTypeVoucher(
            @RequestBody UpdateTypeVoucherDtoRequest request
    ) {
        voucherService.updateTypeVoucher(voucherMapper.toVoucher(request));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('SELLER')")
    public List<VoucherDtoResponse> getVoucher(
            @PathVariable UUID userId
    ) {
        return userServices.getVoucherByUserId(userId)
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
}
