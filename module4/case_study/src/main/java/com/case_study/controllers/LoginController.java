package com.case_study.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/404")
    public String notFoundPage() {
        return "404";
    }

    @GetMapping("/403")
    public String forbiddenPage() {
        return "403";
    }

    @GetMapping("/logoutSuccess")
    public String logOut() {
        return "login";
    }
}
