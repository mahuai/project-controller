package com.pro.manager.exception;

import com.base.result.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ms
 * @Description: 全局异常处理
 * @Package com.pro.manager.exception
 * @date: Created in 2018/9/5  11:15
 */
@ControllerAdvice(basePackages = "com.pro.manager.*")
@ResponseBody
public class GlobalExceptionHandler extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler
    public String runtimeExceptionHandler(HttpServletRequest request, Exception e) {
        try {
            if (e instanceof ArithmeticException) {
                logger.error("operation exception:", e);
                return returnErrorResult(100000);
            }
            if (e instanceof HttpRequestMethodNotSupportedException) {
                logger.warn("Illegal request exception: ", e);
                return returnErrorResult(100001);
            }
        } catch (Exception e1) {
            logger.error("exception: ", e);
        }
        return returnSuccessResult(0);
    }


}
