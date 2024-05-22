package com.example.mall.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ApiUtils<T> {
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult(true, data, null);
    }

    public static <M> ApiResult<M> error(M message, HttpStatus httpStatus) {
        return new ApiResult<M>(false,
                null,
                new ApiError<M>(message, httpStatus));
    }

    @Getter
    @AllArgsConstructor
    public static class ApiResult<T> {

        boolean success;
        T response;
        ApiError<T> error;
    }

    @Getter
    static class ApiError<M>{
        M message;
        HttpStatus httpStatus;

        ApiError(M message, HttpStatus httpStatus) {
            this.message = message;
            this.httpStatus = httpStatus;
        }
    }
}


