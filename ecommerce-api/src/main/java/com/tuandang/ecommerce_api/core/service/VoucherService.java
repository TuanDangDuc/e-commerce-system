package com.tuandang.ecommerce_api.core.service;

import com.tuandang.ecommerce_api.api.dto.request.voucher.VoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.voucher.checkShopVoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.VoucherDtoResponse;
import com.tuandang.ecommerce_api.api.mapper.VoucherMapper;
import com.tuandang.ecommerce_api.core.Enum.Type;
import com.tuandang.ecommerce_api.core.Enum.VoucherType;
import com.tuandang.ecommerce_api.core.domain.ProductVariants;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import com.tuandang.ecommerce_api.core.port.outgoing.ProductVariantRepositoryPort;
import com.tuandang.ecommerce_api.core.port.outgoing.VoucherRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VoucherService {
    private final VoucherRepositoryPort voucherRepositoryPort;
    private final ProductVariantRepositoryPort productVariantRepositoryPort;

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

    public List<Vouchers> getAllVoucherByShopId(UUID shopId) {
        return voucherRepositoryPort.getAllVoucherByShopId(shopId);
    }

    public Vouchers checkShopVoucher(UUID shopId, String code, UUID productVariantId) {
        return voucherRepositoryPort.checkShopVoucher(shopId, code);
    }

    public void updateVoucherUsage(UUID id) {
        voucherRepositoryPort.updateVoucherUsage(id);
    }


    public Float calculate(UUID id, String code, UUID productVariantId, Integer quantity) {
        Vouchers voucher = voucherRepositoryPort.checkShopVoucher(id, code);
        Float productPrice = productVariantRepositoryPort.getProductVariantById(productVariantId);
        if (voucher != null) {
            if (voucher.getType() == VoucherType.FIXED_AMOUNT)
                return (productPrice * quantity) - voucher.getValue();
            else
                return (productPrice * quantity) * (voucher.getValue()/100);
        }
        return -1F;
    }
}
