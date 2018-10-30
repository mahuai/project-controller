package com.pro.manager.controller.system;

import com.admin.api.entity.request.AdminLoginRequestBean;
import com.admin.api.entity.response.AdminResponseBean;
import com.admin.api.exception.LoginException;
import com.admin.api.service.AdminService;
import com.base.result.BaseController;
import com.base.utils.JsonUtils;
import com.base.utils.SessionUtils;
import com.pro.manager.annotation.AuthorityPass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.pro.manager.constant.SystemConstant.ADMIN_INFO_KEY;

/**
 * @author future
 * @Description:
 * @Package com.pro.manager.controller.system
 * @date: Created in 2018/7/1015:04
 */
@Api(description = "admin", tags = "background manager")
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;


    @ApiOperation(value = "login", tags = {"background manager"}, notes = "login", response = AdminResponseBean.class, code = 0)
    @ApiResponses({
            @ApiResponse(code = 200, message = "login success", response = AdminResponseBean.class)
    })
    @AuthorityPass
    @PostMapping("/login")
    public Object login(@Validated AdminLoginRequestBean adminLoginRequestBean, HttpServletRequest request) {
        AdminResponseBean responseBean;
        if (SessionUtils.get(request, ADMIN_INFO_KEY) == null) {
            try {
                responseBean = adminService.login(adminLoginRequestBean);
                if (responseBean == null) {
                    return this.returnErrorResult(10001);
                }
                SessionUtils.set(request, ADMIN_INFO_KEY, responseBean);
            } catch (LoginException e) {
                logger.error("login error:{}", e);
                return this.returnErrorResult(90001);
            }
        }
        return this.returnSuccessResult(0);
    }

    @ApiOperation(value = "get login name", tags = {"background manager"}, notes = "get login name", response = AdminResponseBean.class, code = 0)
    @ApiResponses({
            @ApiResponse(code = 200, message = "get success", response = AdminResponseBean.class)
    })
    @PostMapping("/getLoginName")
    public void getLoginName(HttpServletRequest request) throws Exception {
        AdminResponseBean adminResponseBean = JsonUtils.jsonToBean((String) request.getAttribute("adminInfo"), AdminResponseBean.class);
        logger.info("login name:----->{}", adminResponseBean.getAccount());
    }
}
