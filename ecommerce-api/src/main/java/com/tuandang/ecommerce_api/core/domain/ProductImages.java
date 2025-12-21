package com.tuandang.ecommerce_api.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductImages {
    private UUID id;
    @Column(
            columnDefinition = "TEXT"
    )
    private String url;
    private Products product;
    private Integer imageOrder;
}
