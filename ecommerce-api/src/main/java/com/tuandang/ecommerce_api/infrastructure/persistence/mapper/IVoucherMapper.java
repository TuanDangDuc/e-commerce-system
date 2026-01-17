package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.nimbusds.openid.connect.sdk.assurance.evidences.Voucher;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.VouchersEntity;
import org.springframework.stereotype.Component;

@Component
public class IVoucherMapper {

    public VouchersEntity toVoucherEntity(Vouchers vouchers) {
        return VouchersEntity.builder()
                .id(vouchers.getId())
                .code(vouchers.getCode())
                .type(vouchers.getType())
                .value(vouchers.getValue())
                .maxDiscountAmount(vouchers.getMaxDiscountAmount())
                .minOrderValue(vouchers.getMinOrderValue())
                .startAt(vouchers.getStartAt())
                .endAt(vouchers.getEndAt())
                .usageLimit(vouchers.getUsageLimit())
                .usedCount(vouchers.getUsedCount())
                .isActive(vouchers.getIsActive())
                .scope(vouchers.getScope())
                .seller(UsersEntity.builder()
                        .id(vouchers.getUser().getId())
                        .build())
                .build();
    }

    public VouchersEntity toOnlyActiveVoucherEntity(Vouchers voucher) {
        if (voucher == null)
            throw new NullPointerException("voucher should not be null");
        return VouchersEntity.builder()
                .id(voucher.getId())
                .isActive(voucher.getIsActive())
                .build();
    }

    public VouchersEntity toOnlyScopeVoucherEntity(Vouchers voucher) {
        if (voucher == null)
            throw new NullPointerException("voucher should not be null");
        return VouchersEntity.builder()
                .id(voucher.getId())
                .scope(voucher.getScope())
                .build();
    }

    public VouchersEntity toOnlyTypeVoucherEntity(Vouchers voucher) {
        if (voucher == null)
            throw new NullPointerException("voucher should not be null");
        return VouchersEntity.builder()
                .id(voucher.getId())
                .type(voucher.getType())
                .build();
    }

    public Vouchers toVoucher(VouchersEntity entity) {
        if (entity == null)
            return null;
        return Vouchers.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .type(entity.getType())
                .value(entity.getValue())
                .maxDiscountAmount(entity.getMaxDiscountAmount())
                .minOrderValue(entity.getMinOrderValue())
                .startAt(entity.getStartAt())
                .endAt(entity.getEndAt())
                .usageLimit(entity.getUsageLimit())
                .usedCount(entity.getUsedCount())
                .isActive(entity.getIsActive())
                .scope(entity.getScope())
                .build();
    }

}
