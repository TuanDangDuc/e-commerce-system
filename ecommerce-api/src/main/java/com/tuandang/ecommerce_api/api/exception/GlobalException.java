package com.tuandang.ecommerce_api.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> HandleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        HashMap<String, String> errors = new HashMap<>();
        exp.getBindingResult().getAllErrors().forEach((err)->{
            var fieldName = ((FieldError)err).getField();
            var message = err.getDefaultMessage();
            errors.put(fieldName,message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<?> HandleAppException(AppException exp){
        HashMap<Integer, String> errors = new HashMap<>();
        var errorCode = exp.getErrorCode();
        var errorMessage = exp.getMessage();
        errors.put(errorCode, errorMessage);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
