package com.pro.third.aop;

import com.base.utils.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.third.aop
 * @date: Created in 2018/9/18  11:38
 */
@Aspect
@Configuration
public class CheckSign {

    private static final Logger logger = LoggerFactory.getLogger(CheckSign.class);

    @Pointcut("execution(public * com.pro.third.controller..*(..))")
    public void checkSignPoint() {
    }

    @Around("checkSignPoint()")
    public void checkSign(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();
        String sign = request.getParameter("sign");
        String encrypted = request.getParameter("encrypted");
        if (!StringUtils.isEmpty(sign) && !StringUtils.isEmpty(encrypted)) {

        }

    }

}
