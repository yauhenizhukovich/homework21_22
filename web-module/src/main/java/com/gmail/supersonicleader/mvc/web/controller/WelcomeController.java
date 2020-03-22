package com.gmail.supersonicleader.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping
    public String getWelcomePage() {
        return "welcome";
    }

}
