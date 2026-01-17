package com.tuandang.ecommerce_api.api.mapper;

import com.tuandang.ecommerce_api.api.dto.request.voucher.UpdateActiveVoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.voucher.UpdateScopeVoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.voucher.UpdateTypeVoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.request.voucher.VoucherDtoRequest;
import com.tuandang.ecommerce_api.api.dto.response.VoucherDtoResponse;
import com.tuandang.ecommerce_api.core.domain.Users;
import com.tuandang.ecommerce_api.core.domain.Vouchers;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class VoucherMapper {

    public Vouchers toVoucher(
            VoucherDtoRequest request
    ) {
        return Vouchers.builder()
                .id(request.id())
                .code(request.code())
                .type(request.type())
                .value(request.value())
                .maxDiscountAmount(request.maxDiscountAmount())
                .minOrderValue(request.minOrderValue())
                .startAt(request.startAt())
                .endAt(request.endAt())
                .usageLimit(request.usageLimit())
                .usedCount(request.usedCount())
                .isActive(request.isActive())
                .scope(request.scope())
                .user(Users.builder()
                        .id(request.userId())
                        .build())
                .build();
    }

    public Vouchers toVoucher(
            UpdateActiveVoucherDtoRequest request
    ) {
        return Vouchers.builder()
                .id(request.id())
                .isActive(request.isActive())
                .build();
    }

    public Vouchers  toVoucher(
            UpdateScopeVoucherDtoRequest request
    ) {
        return Vouchers.builder()
                .id(request.id())
                .scope(request.scope())
                .build();
    }
    public Vouchers  toVoucher(
            UpdateTypeVoucherDtoRequest request
    ) {
        return Vouchers.builder()
                .id(request.id())
                .type(request.type())
                .build();
    }


    public VoucherDtoResponse toVoucherDtoResponse(Vouchers voucher) {
        return VoucherDtoResponse.builder()
                .id(voucher.getId())
                .code(voucher.getCode())
                .type(voucher.getType())
                .value(voucher.getValue())
                .maxDiscountAmount(voucher.getMaxDiscountAmount())
                .minOrderValue(voucher.getMinOrderValue())
                .usageLimit(voucher.getUsageLimit())
                .startAt(voucher.getStartAt())
                .endAt(voucher.getEndAt())
                .usedCount(voucher.getUsedCount())
                .isActive(voucher.getIsActive())
                .scope(voucher.getScope())
                .build();
    }
}
