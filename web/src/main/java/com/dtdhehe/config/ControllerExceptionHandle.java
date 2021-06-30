package com.dtdhehe.config;

import com.dtdhehe.common.data.JsonResult;
import com.dtdhehe.common.exception.ParamException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandle {

    @ExceptionHandler
    public JsonResult<String> handle(Exception e){
        if (e instanceof ParamException){
            // 参数异常
            return JsonResult.error(e.getMessage());
        }
        return null;
    }

}
