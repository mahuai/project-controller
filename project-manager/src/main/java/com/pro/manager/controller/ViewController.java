package com.pro.manager.controller;

import com.base.utils.SessionUtils;
import com.pro.manager.annotation.AuthorityPass;
import com.pro.manager.annotation.SkipLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.pro.manager.constant.SystemConstant.ADMIN_INFO_KEY;

/**
 * @author ms
 * @Description:
 * @Package com.pro.manager.controller
 * @date: Created in 2018/7/18 16:24
 */

@Api(description = "home and login page", tags = "background manager")
@Controller
public class ViewController {

    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);


    @ApiOperation(value = "jump home and login page", tags = {"background manager"}, notes = "jump home and login page", code = 0)
    @ApiResponses({
            @ApiResponse(code = 200, message = "jump success")
    })
    @GetMapping("/")
    public String loginPage(HttpServletRequest request) {
        if (SessionUtils.get(request, ADMIN_INFO_KEY) != null) {
            return "home";
        }
        return "login";
    }


    @ApiOperation(value = "test annotation", tags = {"background manager"}, notes = "test annotation", code = 0)
    @ApiResponses({
            @ApiResponse(code = 200, message = "test success")
    })
    @SkipLogin
    @AuthorityPass
    @GetMapping("/annotation")
    public void annotation(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            PrintWriter writer = response.getWriter();
            writer.print("annotation test pass");
        } catch (IOException e) {
            logger.error("io exception:", e);
        }
        logger.info("in method--------------->:annotation");
    }

    public static void main(String[] args) {

        System.out.println();
    }
}
