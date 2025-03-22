package com.ajmayen.myrestaurant.controller;

import com.ajmayen.myrestaurant.model.RestaurantUser;
import com.ajmayen.myrestaurant.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/signin")
    public String SignInUser(Model model){
        RestaurantUser restaurantUser = new RestaurantUser();
        model.addAttribute("user",restaurantUser);
        return "SignIn";
    }

    @PostMapping("/loginSubmit")
    public String loggedInUser(Model model, @ModelAttribute RestaurantUser restaurantUser, RedirectAttributes redirectAttributes, @RequestParam("restaurantEmailAddress") String restaurantEmailAddress, @RequestParam("password") String password){

        System.out.println("Email: "+restaurantEmailAddress);
        System.out.println("password: "+password);
       RestaurantUser user = userService.loggedInUser(restaurantEmailAddress,password);
       if(user != null){
           System.out.println("user found: "+user.getRestaurantName());
           model.addAttribute("user",user);
           redirectAttributes.addFlashAttribute("success","Login Successful");
           return "redirect:/dashboard";
       }
       else {
           System.out.println("user not found");
           redirectAttributes.addFlashAttribute("error","Invalid email or password");
           return "redirect:/signin";
       }


    }


    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Add any necessary model attributes
        return "DashBoard"; // Name of the Thymeleaf template (Dashboard.html)
    }


}
