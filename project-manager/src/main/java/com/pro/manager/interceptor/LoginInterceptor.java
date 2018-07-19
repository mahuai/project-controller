package com.pro.manager.interceptor;

import com.admin.api.entity.response.AdminResponseBean;
import com.pro.base.result.ReturnResult;
import com.pro.utils.JsonUtils;
import com.pro.utils.SessionUtils;
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
import java.util.Locale;

import static com.pro.manager.constant.SystemConstant.ADMIN_INFO_KEY;

/**
 * @author future
 * @Description:
 * @Package com.pro.manager.interceptor project-controller
 * @date: Created in 2018/7/1313:50
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private ResourceBundleMessageSource errorMessageSource;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        AdminResponseBean responseBean = (AdminResponseBean) SessionUtils.get(request, ADMIN_INFO_KEY);
        if (responseBean == null) {
            logger.warn("请求该方法需要登录---->{}", request.getRequestURI());
            String errorMessage = errorMessageSource.getMessage(String.valueOf(10000), null, Locale.SIMPLIFIED_CHINESE);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(JsonUtils.objtoJson(new ReturnResult(10000, null, errorMessage)));
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
