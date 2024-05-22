package com.example.mall.utils;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.example.mall.utils.ApiUtils.error;

@RestControllerAdvice
public class HandleException {
    //유효성 검사 중 에러 발생 시 호출되는 예외 처리 메소드
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiUtils.ApiResult<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException errors){
        Map<String, String> errorMessages = new HashMap<>();

        for(FieldError error: errors.getFieldErrors()){
            String errorField = error.getField(); // 예외 field
            String errorMessage = error.getDefaultMessage();// 예외 message
            errorMessages.put(errorField,errorMessage);
        }

        return error(errorMessages, HttpStatus.BAD_REQUEST);
    }

}
