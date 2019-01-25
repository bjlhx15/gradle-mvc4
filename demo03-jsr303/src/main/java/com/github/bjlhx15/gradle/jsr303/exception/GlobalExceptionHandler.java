package com.github.bjlhx15.gradle.jsr303.exception;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihongxu
 * @desc @link(https://github.com/bjlhx15/gradle-mvc4)
 * @since 2019/1/23 下午2:01
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity constraintViolationExceptionHandler(Exception e) {
        Map<String,Object> result=new HashMap();
        result.put("code",400);
        result.put("msg",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @ExceptionHandler(value = javax.validation.UnexpectedTypeException.class)
    @ResponseBody
    public ResponseEntity unexpectedTypeExceptionHandler(Exception e) {
        Map<String,Object> result=new HashMap();
        result.put("code",400);
        result.put("msg",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @ExceptionHandler(value = org.springframework.http.converter.HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity httpMessageNotReadableExceptionHandler(Exception e) {
        Map<String,Object> result=new HashMap();
        result.put("code",400);
        result.put("msg","没有请求体，详细："+e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }


    @ExceptionHandler(value = org.springframework.web.bind.MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        Map<String,Object> result=new HashMap();
        result.put("code",400);
        result.put("msg","请求体校验失败，详细："+e.getMessage());
        if (e.getBindingResult().hasErrors()) {
            List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
            result.put("data",fieldErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    @ExceptionHandler(value = Exception.class)
    public void errorHandler(Exception e,HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
