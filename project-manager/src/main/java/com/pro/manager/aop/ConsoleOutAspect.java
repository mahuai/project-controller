package com.pro.manager.aop;


import com.base.utils.HttpUtils;
import com.base.utils.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author future
 * @Description:
 * @Package com.pro.manager.aop project-controller
 * @date: Created in 2018/7/1017:22
 */

@Aspect
@Component
public class ConsoleOutAspect {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleOutAspect.class);

    @Pointcut("execution(public * com.pro.manager.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void consoleOut() {
    }

    @Before("consoleOut()")
    public void doBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String args = JsonUtils.objtoJson(parameterMap);
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        // 浏览器信息
        String browserInfo = HttpUtils.getBrowserName(request);
        // 请求方式
        String requestWay = request.getMethod();
        // 客户端的IP地址
        String iPAddress = HttpUtils.getClientIpAddr(request);
        logger.info("\033[0;32m \n sessionId: {}; \n 客户端的IP地址: {};\n 浏览器信息: {};\n 请求方式: {};\n 请求方法: {};\n 请求参数: {};\033[0m", sessionId, iPAddress, browserInfo, requestWay, method.getName(), args);
        MDC.put("sessionId", request.getSession().getId());
    }


    @After(value = "consoleOut()")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String s = JsonUtils.objtoJson(parameterMap);
        logger.info(method.getName());
    }

    @AfterReturning(value = "consoleOut()", returning = "result")
    public void returnResult(JoinPoint joinPoint, Object result) {
        logger.info("\033[0;32m \n 请求方法: {}; \n 返回结果: {}\033[0m", joinPoint.getSignature().getName(), result);
        MDC.put("sessionId", "");
    }
}
