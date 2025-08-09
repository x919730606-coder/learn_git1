package com.bjpowernode.exception;


import com.bjpowernode.result.Result;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.FAIL(e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public Result handleException(NullPointerException e) {
        e.printStackTrace();
        return Result.FAIL("出现空指针");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Result handleException(DataIntegrityViolationException e) {
        e.printStackTrace();
        return Result.FAIL("外键约束异常");
    }
}
