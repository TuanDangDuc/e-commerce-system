package com.tuandang.ecommerce_api.core.port.outgoing;

import com.tuandang.ecommerce_api.core.domain.Vouchers;

import java.util.UUID;

public interface VoucherRepositoryPort {
    public void save(Vouchers voucher);

    public void setActiveVoucher(Vouchers voucher);

    public void setScopeVoucher(Vouchers voucher);

    public void setTypeVoucher(Vouchers voucher);

    public void deleteById(UUID id);
}
