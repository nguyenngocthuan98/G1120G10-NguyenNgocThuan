package com.case_study.controllers;

import com.case_study.models.Customer;
import com.case_study.services.CustomerService;
import com.case_study.services.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("/")
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
    public String create(Customer customer, RedirectAttributes redirect) {
        this.customerService.save(customer);
        redirect.addFlashAttribute("messSuccess",
                "Added successfully: " + customer.getCustomerName());
        return "redirect:/customer/";
    }

    @GetMapping("/viewEdit")
    public String viewEdit(@RequestParam(name = "id") String id, Model model) {
        model.addAttribute("listCustomerType", this.customerTypeService.findAll());
        model.addAttribute("customer", this.customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(Customer customer, RedirectAttributes redirect) {
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
    public String search(@RequestParam Optional<String> search, Model model, @PageableDefault(value = 5) Pageable pageable) {
        if (search.isPresent()) {
            model.addAttribute("listCustomer", this.customerService.findAllByCustomerName(search.get(), pageable));
        } else {
            model.addAttribute("listCustomer", this.customerService.findAll(pageable));
        }
        return "customer/list";
    }
}
