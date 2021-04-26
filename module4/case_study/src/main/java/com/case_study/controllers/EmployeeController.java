package com.case_study.controllers;

import com.case_study.models.Employee;
import com.case_study.models.User;
import com.case_study.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private UserService userService;

    public void getAll(Model model) {
        model.addAttribute("educationdegree", this.educationDegreeService.findAll());
        model.addAttribute("division", this.divisionService.findAll());
        model.addAttribute("position", this.positionService.findAll());
        model.addAttribute("user", this.userService.findAll());
    }

    @GetMapping("/")
    public String getEmployeeHome(@PageableDefault(value = 5) Pageable pageable, Model model) {
        model.addAttribute("employee", this.employeeService.findAll(pageable));
        return "employee/list";
    }

    @GetMapping("/viewDetail")
    public String viewDetail(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("employee", this.employeeService.findById(id));
        return "employee/detail";
    }

    @GetMapping("/viewCreate")
    public String viewCreate(Model model) {
        model.addAttribute("employee", new Employee());
        getAll(model);
        return "employee/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                         @RequestParam("inputUsername") String username, RedirectAttributes redirect, Model model) {
        new Employee().validate(employee, bindingResult);
        this.userService.checkUsername(username, bindingResult);
        if (bindingResult.hasErrors()) {
            if (bindingResult.hasFieldErrors("user")) {
                model.addAttribute("messUser", "user.username.existed");
            }
            model.addAttribute("employee", employee);
            getAll(model);
            return "employee/create";
        }
        User user = this.userService.createUserByUsername(username);
        employee.setUser(user);
        this.employeeService.save(employee);
        redirect.addFlashAttribute("messSuccess",
                "Added successfully: " + employee.getEmployeeName());
        return "redirect:/employee/";
    }

    @GetMapping("/viewEdit")
    public String viewEdit(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("employee", this.employeeService.findById(id));
        getAll(model);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model,
                       RedirectAttributes redirect) {
        new Employee().validate(employee, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", employee);
            getAll(model);
            return "employee/edit";
        }
        this.employeeService.save(employee);
        redirect.addFlashAttribute("messSuccess",
                "Updated successfully: " + employee.getEmployeeName());
        return "redirect:/employee/";
    }

    @GetMapping("/viewDelete")
    public ModelAndView viewDelete(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("employee/delete", "employeeDel", this.employeeService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id, RedirectAttributes redirect) {
        redirect.addFlashAttribute("messSuccess",
                "Deleted successfully: " + this.employeeService.findById(id).getEmployeeName());
        this.employeeService.findById(id).getUser().setEnabled(false);
        this.employeeService.deleteById(id);
        return "redirect:/employee/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") Optional<String> search, Model model,
                         @PageableDefault(value = 5) Pageable pageable) {
        if (search.isPresent()) {
            model.addAttribute("search", search.get());
            model.addAttribute("employee",
                    this.employeeService.findAllByEmployeeNameContaining(search.get(), pageable));
        } else {
            model.addAttribute("employee", this.employeeService.findAll(pageable));
        }
        return "employee/list";
    }
}
