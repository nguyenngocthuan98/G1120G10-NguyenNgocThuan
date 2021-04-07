package com.validate.exercise_validate.controllers;

import com.validate.exercise_validate.models.User;
import com.validate.exercise_validate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView getFormView() {
        return new ModelAndView("register", "user", new User());
    }

    @PostMapping("/createUser")
    public String createUser(@Valid User user, BindingResult bindingResult, Model model) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            this.userService.save(user);
            return "home";
        }
    }
}

