package com.pro.manager.controller;

import com.pro.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.pro.manager.constant.SystemConstant.ADMIN_INFO_KEY;

/**
 * @author ms
 * @Description:
 * @Package com.pro.manager.controller
 * @date: Created in 2018/7/18 16:24
 */
@Controller
public class ViewController {


    @GetMapping("/")
    public String loginPage(HttpServletRequest request) {
        if (SessionUtils.get(request, ADMIN_INFO_KEY) != null) {
            return "home";
        }
        return "login";
    }
}
