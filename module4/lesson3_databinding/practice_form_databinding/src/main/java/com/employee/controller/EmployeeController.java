package com.employee.controller;

import com.employee.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @GetMapping("/")
    public ModelAndView getCreateView() {
        return new ModelAndView("create_page", "create", new Employee());
    }

    @PostMapping("/create")
    public ModelAndView createAction(@ModelAttribute("create") Employee employee){
        return new ModelAndView("index", "employee", employee);
    }
}
