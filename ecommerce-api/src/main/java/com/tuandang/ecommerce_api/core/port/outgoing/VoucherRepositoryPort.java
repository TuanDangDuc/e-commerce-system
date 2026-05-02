package com.tuandang.ecommerce_api.core.port.outgoing;

import com.nimbusds.openid.connect.sdk.assurance.evidences.Voucher;
import com.tuandang.ecommerce_api.core.domain.Vouchers;

import java.util.List;
import java.util.UUID;

public interface VoucherRepositoryPort {
    public void save(Vouchers voucher);

    public void setActiveVoucher(Vouchers voucher);

    public void setScopeVoucher(Vouchers voucher);

    public void setTypeVoucher(Vouchers voucher);

    public void deleteById(UUID id);

    public List<Vouchers> getAllVoucherByShopId(UUID shopId);

    public Vouchers checkShopVoucher(UUID shopId, String code);

    public void updateVoucherUsage(UUID id);

    public Vouchers getVoucherById(UUID id);
}
