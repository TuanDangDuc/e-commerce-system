package com.tuandang.ecommerce_api.api.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final Integer errorCode;
    public AppException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
