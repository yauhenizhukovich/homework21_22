package com.gmail.supersonicleader.mvc.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class,
        scanBasePackages = {
                "com.gmail.supersonicleader.mvc.web.controller",
                "com.gmail.supersonicleader.mvc.web.config",
                "com.gmail.supersonicleader.mvc.service.impl",
                "com.gmail.supersonicleader.mvc.service.config",
                "com.gmail.supersonicleader.mvc.repository.config",
                "com.gmail.supersonicleader.mvc.repository.impl"
        })
public class WebModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebModuleApplication.class, args);
    }

}
