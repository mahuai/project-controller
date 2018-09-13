package com.pro.manager.interceptor;

import com.admin.api.entity.response.AdminResponseBean;

import com.base.utils.JsonUtils;
import com.base.utils.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.pro.manager.constant.SystemConstant.ADMIN_INFO_KEY;

/**
 * @author ms
 * @Description:
 * @Package com.pro.manager.interceptor
 * @date: Created in 2018/7/18 11:41
 */
public class InitInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(InitInterceptor.class);

    private static String BASE_PATH = null;

    private static String ADMIN_INFO = "adminInfo";

    private static final Object OBJECT = new Object();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("init -------------------------->{}", InitInterceptor.class);
        request.setAttribute("basePath", getBasePath(request));
        AdminResponseBean responseBean = (AdminResponseBean) SessionUtils.get(request, ADMIN_INFO_KEY);
        request.setAttribute(ADMIN_INFO, JsonUtils.objtoJson(responseBean == null ? new AdminResponseBean() : responseBean));
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    private static String getBasePath(HttpServletRequest request) {
        synchronized (OBJECT) {
            if (BASE_PATH != null) {
                return BASE_PATH;
            }
            BASE_PATH = request.getContextPath() + request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort();
        }
        return BASE_PATH;
    }
}
