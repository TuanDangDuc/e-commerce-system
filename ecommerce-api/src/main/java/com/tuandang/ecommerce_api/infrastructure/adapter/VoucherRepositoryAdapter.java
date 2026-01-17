package com.tuandang.ecommerce_api.infrastructure.adapter;

import com.tuandang.ecommerce_api.core.domain.Vouchers;
import com.tuandang.ecommerce_api.core.port.outgoing.VoucherRepositoryPort;
import com.tuandang.ecommerce_api.infrastructure.persistence.mapper.IVoucherMapper;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.VouchersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class VoucherRepositoryAdapter implements VoucherRepositoryPort {
    private final VouchersRepository vouchersRepository;
    private final IVoucherMapper voucherMapper;

    @Override
    public void save(Vouchers voucher) {
        vouchersRepository.save(voucherMapper.toVoucherEntity(voucher));
    }

    @Override
     public void setActiveVoucher(Vouchers voucher) {
        vouchersRepository.setActiveVoucher(voucherMapper.toOnlyActiveVoucherEntity(voucher));
    }

    @Override
    public void setScopeVoucher(Vouchers voucher) {
        vouchersRepository.setScopeVoucher(voucherMapper.toOnlyScopeVoucherEntity(voucher));
    }

    @Override
    public void setTypeVoucher(Vouchers voucher) {
        vouchersRepository.setTypeVoucher(voucherMapper.toOnlyTypeVoucherEntity(voucher));
    }

    @Override
    public void deleteById(UUID id) {
        vouchersRepository.deleteById(id);
    }
}
