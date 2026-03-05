package com.tuandang.ecommerce_api.infrastructure.persistence.mapper;

import com.nimbusds.openid.connect.sdk.assurance.evidences.Voucher;
import com.tuandang.ecommerce_api.core.Enum.Scope;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.UsersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.entity.VouchersEntity;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.ShopsRepository;
import com.tuandang.ecommerce_api.infrastructure.persistence.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IVoucherMapper {
    private final UsersRepository usersRepository;
    private final ShopsRepository shopsRepository;

    public VouchersEntity toVoucherEntity(Vouchers vouchers) {
        return VouchersEntity.builder()
                .name(vouchers.getName())
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
                .scope(Scope.SHOP_VOUCHER)
                .shops(shopsRepository.getReferenceById(vouchers.getShop().getId()))
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
                .name(entity.getName())
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
