package com.pro.manager.aop;


import com.pro.utils.HttpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author future
 * @Description:
 * @Package com.pro.manager.aopproject-controller
 * @date: Created in 2018/7/1017:22
 */

@Aspect
@Component
public class ConsoleOutAspect {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleOutAspect.class);

    @Pointcut("execution(public * com.pro.manager.controller..*(..))")
    public void consoleOut() {
    }

    @Before("consoleOut()")
    public void doBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        // 浏览器信息
        String browserInfo = HttpUtils.getBrowserName(request);
        // 请求方式
        String requestWay = request.getMethod();
        // 客户端的IP地址
        String iPAddress = HttpUtils.getClientIpAddr(request);
        logger.info("\033[0;32m \n sessionId: {}; \n 客户端的IP地址: {};\n 浏览器信息: {};\n 请求方式: {};\n 请求方法: {};\033[0m", sessionId, iPAddress, browserInfo, requestWay, method.getName());
    }

    @AfterReturning(value = "consoleOut()", returning = "result")
    public void returnResult(JoinPoint joinPoint, Object result) {
        logger.info("\033[0;32m \n 请求方法: {}; \n 返回结果: {}\033[0m", joinPoint.getSignature().getName(), result);
    }
}
