package com.pro.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author future
 * @Description:
 * @Package com.pro.manager
 * @date: Created in 2018/7/1014:52
 */
@SpringBootApplication
@ServletComponentScan
@ImportResource("classpath:spring/*.xml")
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class);
    }
}
