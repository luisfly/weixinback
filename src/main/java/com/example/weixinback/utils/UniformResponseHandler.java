package com.example.weixinback.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 拦截 response 并添加必要信息
 * @param <T>
 */
@RestControllerAdvice(annotations = RestController.class)
public class UniformResponseHandler<T> {

    @ResponseStatus(HttpStatus.OK)
    public CustResponseEntity sendSuccessResponse() {
        return new CustResponseEntity(true, CodeAndMsg.SUCCESS, null);
    }

    @ResponseStatus(HttpStatus.OK)
    public CustResponseEntity sendSuccessResponse(T data) {
        return new CustResponseEntity(true, CodeAndMsg.SUCCESS, data);
    }

    @ExceptionHandler(UserDefinedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustResponseEntity sendErrorResponse_UserDefined(Exception exception) {
        return new CustResponseEntity(false, ((UserDefinedException) exception).getException(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustResponseEntity sendErrorResponse_Systerm(Exception exception) {
        if (exception instanceof UserDefinedException) {
            return this.sendErrorResponse_UserDefined(exception);
        }

        return new CustResponseEntity(false, CodeAndMsg.UNKNOWECEPTION, null);
    }
}
