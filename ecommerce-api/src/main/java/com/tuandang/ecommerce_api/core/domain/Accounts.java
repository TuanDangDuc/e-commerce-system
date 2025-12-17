package com.tuandang.ecommerce_api.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.nio.Buffer;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Accounts {
    private UUID id;
    private String userName;
    private String password;
    private String email;
}
