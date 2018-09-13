package com.pro.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.client.controller
 * @date: Created in 2018/9/5  9:44
 */
@Controller
public class ViewController {

    @GetMapping("login/page")
    public Object login() {
        return "";
    }
}
