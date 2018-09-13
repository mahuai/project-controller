package com.pro.manager.interceptor;


import com.base.result.ReturnResult;
import com.base.utils.JsonUtils;
import com.base.utils.StringUtils;
import com.pro.manager.annotation.AuthorityPass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Locale;


/**
 * @author ms
 * @Description: class description
 * @Package com.pro.manager.interceptor
 * @date: Created in 2018/9/6  11:20
 */
public class AuthorityInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthorityInterceptor.class);

    @Autowired
    private ResourceBundleMessageSource errorMessageSource;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("authority interceptor--------------->");

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        AuthorityPass authorityPass = method.getAnnotation(AuthorityPass.class);
        if (authorityPass != null) {
            if (authorityPass.flag()) {
                return true;
            }
        }
        String parentId = request.getParameter("parentId");

        if (StringUtils.isEmpty(parentId)) {
            logger.warn("没有操作权限---->{}", request.getRequestURI());
            String errorMessage = errorMessageSource.getMessage(String.valueOf(20001), null, Locale.SIMPLIFIED_CHINESE);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=UTF-8");
            response.setLocale(Locale.SIMPLIFIED_CHINESE);
            PrintWriter writer = response.getWriter();
            writer.print(JsonUtils.objtoJson(new ReturnResult(20001, null, errorMessage)));
            writer.close();
            return false;
        }

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
