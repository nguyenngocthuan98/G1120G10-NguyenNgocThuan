package com.login.controller;

import com.login.model.Login;
import com.login.model.User;
import com.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login_page", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView loginAction(@ModelAttribute("login") Login login){
        User user = loginService.checkLogin(login);
        ModelAndView modelAndView;
        if (user == null){
            modelAndView = new ModelAndView("login_page");
            modelAndView.addObject("error", "Wrong");
        } else {
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
}
