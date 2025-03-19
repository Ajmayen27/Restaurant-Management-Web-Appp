package com.ajmayen.myrestaurant.controller;

import com.ajmayen.myrestaurant.model.RestaurantUser;
import com.ajmayen.myrestaurant.service.UserService;
import jdk.management.jfr.RemoteRecordingStream;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/home")
    public ModelAndView getLandingPage(ModelAndView modelAndView){
        modelAndView.setViewName("Home");
        return modelAndView;
    }


    @GetMapping("/signup")
    public String showSignUpForm(Model model){
        RestaurantUser restaurantUser = new RestaurantUser();
        model.addAttribute("user",restaurantUser);
        return "SignUp";
    }


    @PostMapping("/submit")
    public String singUpUser(Model model,@ModelAttribute RestaurantUser restaurantUser,RedirectAttributes redirectAttributes) {
        userService.registerUser(restaurantUser);
        redirectAttributes.addFlashAttribute("success","Registration Successful");
        model.addAttribute("restaurantUser",restaurantUser);
        return "redirect:/home";
    }

//    @GetMapping("/signin")
//    public String SignInUser(){
//
//    }




}
