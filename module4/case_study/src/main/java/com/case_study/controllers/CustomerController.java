package com.case_study.controllers;

import com.case_study.models.Customer;
import com.case_study.services.ContractService;
import com.case_study.services.CustomerService;
import com.case_study.services.CustomerTypeService;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private ContractService contractService;

    @GetMapping("")
    public ModelAndView getCustomerHome(@PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("customer/list", "listCustomer",
                this.customerService.findAll(pageable));
    }

    @GetMapping("/viewDetail")
    public String viewDetail(@RequestParam(name = "id") String id, Model model) {
        model.addAttribute("listCustomerType", this.customerTypeService.findAll());
        model.addAttribute("customer", this.customerService.findById(id));
        return "customer/detail";
    }

    @GetMapping("/viewCreate")
    public String viewCreate(Model model) {
        model.addAttribute("customerCreate", new Customer());
        model.addAttribute("listCustomerType", this.customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("customerCreate") Customer customer, BindingResult bindingResult,
                         RedirectAttributes redirect, Model model) {
        new Customer().validate(customer, bindingResult);
        this.customerService.checkCustomerId(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerCreate", customer);
            model.addAttribute("listCustomerType", this.customerTypeService.findAll());
            return "customer/create";
        }
        this.customerService.save(customer);
        redirect.addFlashAttribute("messSuccess",
                "Added successfully: " + customer.getCustomerName());
        return "redirect:/customer/";
    }

    @GetMapping("/viewEdit")
    public String viewEdit(@RequestParam(name = "id") String id, Model model) {
        model.addAttribute("listCustomerType", this.customerTypeService.findAll());
        model.addAttribute("customerEdit", this.customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("customerEdit") Customer customer, BindingResult bindingResult,
                       Model model, RedirectAttributes redirect) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("listCustomerType", this.customerTypeService.findAll());
            model.addAttribute("customerEdit", customer);
            return "customer/edit";
        }
        this.customerService.save(customer);
        redirect.addFlashAttribute("messSuccess",
                "Updated successfully: " + customer.getCustomerName());
        return "redirect:/customer/";
    }

    @GetMapping("/viewDelete")
    public ModelAndView viewDelete(@RequestParam(name = "id") String id) {
        return new ModelAndView("customer/delete", "customerDel", this.customerService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "customerId") String id, RedirectAttributes redirect) {
        redirect.addFlashAttribute("messSuccess",
                "Deleted successfully: " + this.customerService.findById(id).getCustomerName());
        this.customerService.deleteById(id);
        return "redirect:/customer/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") Optional<String> search, Model model, @PageableDefault(value = 5) Pageable pageable) {
        if (search.isPresent()) {
            model.addAttribute("search", search.get());
            model.addAttribute("listCustomer",
                    this.customerService.findAllByCustomerNameContainingOrCustomerIdContaining(
                            search.get(), search.get(), pageable
                    ));
        } else {
            model.addAttribute("listCustomer", this.customerService.findAll(pageable));
        }
        return "customer/list";
    }

    @GetMapping("/customerUsing")
    public String showUsingCustomer(Model model, @PageableDefault(value = 5) Pageable pageable) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        model.addAttribute("listUsingCustomer", this.contractService.customersUsing(date, pageable));
        return "customer/using";
    }
}
