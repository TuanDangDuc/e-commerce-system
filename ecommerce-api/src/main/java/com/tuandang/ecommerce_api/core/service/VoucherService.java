package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.core.domain.Vouchers;
import com.tuandang.ecommerce_api.core.port.outgoing.VoucherRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoucherService {
    private final VoucherRepositoryPort voucherRepositoryPort;

    public void save(Vouchers voucher) {
        voucherRepositoryPort.save(voucher);
    }

    public void updateActiveVoucher(Vouchers voucher) {
        voucherRepositoryPort.setActiveVoucher(voucher);
    }

    public void updateScopeVoucher(Vouchers voucher) {
        voucherRepositoryPort.setScopeVoucher(voucher);
    }

    public void updateTypeVoucher(Vouchers voucher) {
        voucherRepositoryPort.setTypeVoucher(voucher);
    }

    public void deleteVoucherById(UUID id) {
        voucherRepositoryPort.deleteById(id);
    }
}
