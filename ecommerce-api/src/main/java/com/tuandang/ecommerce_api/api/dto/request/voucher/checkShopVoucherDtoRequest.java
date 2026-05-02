package com.tuandang.ecommerce_api.api.dto.request.voucher;

import java.util.UUID;

public record checkShopVoucherDtoRequest(
        UUID shopId,
        String code,
        UUID productVariantId,
        Integer quantity
) {
}
