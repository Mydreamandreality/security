package com.mobile.security.config;

import com.mobile.security.base.IException;
import com.mobile.security.base.constants.enums.GeekExceptionMsg;
import com.mobile.security.base.constants.response.ServiceResult;
import com.mobile.security.config.conver.DateConverter;
import com.mobile.security.utils.SnowFlake;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * @Author 张耀烽
 * @Date Created in 2021/8/23 00:00
 * @Version v1.0
 * @Description TODO
 */
@RestControllerAdvice
public class BaseControllerAdvice<T> {

    /**
     * 时间参数转换
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(new DateConverter().convert(text));
            }
        });

    }

    @ExceptionHandler(IException.class)
    public ServiceResult<T> IException(IException e) {
        return ServiceResult.failure(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServiceResult<T> IException(MethodArgumentNotValidException e) {
        return ServiceResult.failure(
                GeekExceptionMsg.BAD_REQUEST_ERROR.getCode(),
                e.getBindingResult().getFieldError().getDefaultMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    public ServiceResult<T> sysException(Exception e) {
        return ServiceResult.failure(GeekExceptionMsg.SERVER_ERROR.getCode(), e.toString());
    }
}
