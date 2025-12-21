package com.tuandang.ecommerce_api.api.dto.request.productImage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class AddImagesDtoRequest {
    @NotNull
    private UUID productId;
    @NotEmpty
    private List<String> images;
}
