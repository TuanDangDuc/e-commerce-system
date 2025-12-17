package com.tuandang.ecommerce_api.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalCoreException {
    @ExceptionHandler(AccountAlreadyExitsException.class)
    public ResponseEntity<?> HandleAccountAlreadyExitsException(
            AccountAlreadyExitsException exp
    ){
        var errs = new HashMap<Integer, String>();
        errs.put(exp.getErrorCode(), exp.getMessage());
        return  new ResponseEntity<>(errs, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> HandleAccountNotFoundException(
            AccountNotFoundException exp
    ){
        var errs = new HashMap<Integer, String>();
        errs.put(exp.getErrorCode(), exp.getMessage());
        return  new ResponseEntity<>(errs, HttpStatus.BAD_REQUEST);
    }
}
