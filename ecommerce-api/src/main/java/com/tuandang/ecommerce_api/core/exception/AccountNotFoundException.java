package com.tuandang.ecommerce_api.core.exception;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import org.springframework.web.service.annotation.GetExchange;

@Getter
public class AccountNotFoundException extends RuntimeException {
    private final Integer errorCode;
    public AccountNotFoundException(Integer errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
