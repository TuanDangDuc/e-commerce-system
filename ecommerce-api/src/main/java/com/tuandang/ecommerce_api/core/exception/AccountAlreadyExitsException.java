package com.tuandang.ecommerce_api.core.exception;

import lombok.Getter;

@Getter
public class AccountAlreadyExitsException extends RuntimeException {
    private final Integer errorCode;
    public AccountAlreadyExitsException(Integer errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
