package com.ajmayen.myrestaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/home")
    public ModelAndView getLandingPage(ModelAndView modelAndView) {
        modelAndView.setViewName("Landing");
        return modelAndView;
    }


}
