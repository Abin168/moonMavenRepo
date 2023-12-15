package com.moon.core.exception.handler;

import com.moon.core.common.result.R;
import com.moon.core.enums.CodeMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public R<?> validatedBindException(BindException e) {
        log.error("GlobalExceptionHandler validatedBindException", e);
        return R.error(CodeMsg.ERROR.getCode(), e.getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<?> validExceptionHandler(MethodArgumentNotValidException e) {
        log.error("GlobalExceptionHandler validExceptionHandler", e);
        return R.error(CodeMsg.ERROR.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public R<?> handleException(Exception e) {
        log.error("GlobalExceptionHandler handleException", e);
        return R.error(CodeMsg.ERROR.getCode(), CodeMsg.ERROR.getMsg());
    }

    @ExceptionHandler(RuntimeException.class)
    public R<?> handleRuntimeException(RuntimeException e) {
        log.error("GlobalExceptionHandler handleRuntimeException", e);
        return R.error(CodeMsg.ERROR.getCode(), CodeMsg.ERROR.getMsg());
    }

}