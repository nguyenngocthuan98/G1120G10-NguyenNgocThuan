package com.validate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailValidateController {
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String PASSWORD_REGEX = "^\\w+$";

    private boolean validateEmail(String regex) {
        matcher = Pattern.compile(EMAIL_REGEX).matcher(regex);
        return matcher.matches();
    }

    private boolean validatePassword(String regex) {
        matcher = Pattern.compile(PASSWORD_REGEX).matcher(regex);
        return matcher.matches();
    }

    @PostMapping("/login")
    public String loginValidate(@RequestParam String email, @RequestParam String password, Model model) {
        boolean isValidEmail = this.validateEmail(email);
        boolean isValidPassword = this.validatePassword(password);

        if (!isValidEmail) {
            model.addAttribute("email", email);
            model.addAttribute("messageInValidEmail", "Email example: example@eample.example");
            return "login";
        } else if(!isValidPassword) {
            model.addAttribute("email", email);
            model.addAttribute("messageInValidPassword", "Wrong password");
            return "login";
        } else{
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            return "index";
        }
    }

    @GetMapping("/")
    public String getLogin() {
        return "login";
    }
}
