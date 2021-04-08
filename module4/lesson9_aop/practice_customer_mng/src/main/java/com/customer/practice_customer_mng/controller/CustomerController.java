package com.customer.practice_customer_mng.controller;

import com.customer.practice_customer_mng.model.Customer;
import com.customer.practice_customer_mng.model.Province;
import com.customer.practice_customer_mng.service.CustomerService;
import com.customer.practice_customer_mng.service.ProvinceService;
import com.customer.practice_customer_mng.service.exception.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"", "/customer"})
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProvinceService provinceService;

    @GetMapping("")
    public String getHome(Model model, @PageableDefault(value = 2) Pageable pageable) {
        List<Province> listProvince = this.provinceService.findAll();
        Page<Customer> listCustomer = this.customerService.findAll(pageable);
        model.addAttribute("customer", new Customer());
        model.addAttribute("listProvince", listProvince);
        model.addAttribute("listCustomer", listCustomer);
        return "index";
    }

    @PostMapping("/create")
    public String createCustomer(Customer customer, RedirectAttributes redirect) {
        try {
            this.customerService.save(customer);
            redirect.addFlashAttribute("message", "Customer " + customer.getName() + " was added");
        } catch (DuplicateEmailException e) {
            redirect.addFlashAttribute("message", "Create fail! " + customer.getEmail() + " existed");
        }
        return "redirect:/customer/";
    }

    @GetMapping("/view")
    public String viewCustomer(@RequestParam Integer id, Model model) {
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/view";
    }

    @GetMapping("/show_edit")
    public String showEdit(@RequestParam Integer id, Model model) {
        List<Province> listProvince = this.provinceService.findAll();
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("listProvince", listProvince);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(Customer customer, RedirectAttributes redirect, @RequestParam Integer id, Model model) {
        try {
            this.customerService.save(customer);
            redirect.addFlashAttribute("message", "Information of customer " + customer.getName() + " was updated");
            return "redirect:/customer/";
        } catch (DuplicateEmailException e) {
            model.addAttribute(id);
            model.addAttribute("mess", "Email existed");
            return showEdit(id, model);
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id, RedirectAttributes redirect) {
        this.customerService.remove(id);
        redirect.addFlashAttribute("message", "Customer was deleted!");
        return "redirect:/customer/";
    }

    @GetMapping("/province")
    public String viewProvinceCustomer(@RequestParam String provinceName, Model model) {
        List<Customer> listCustomer = this.customerService.findAllByProvinceName(provinceName);
        model.addAttribute("provinceName", provinceName);
        model.addAttribute("listCustomer", listCustomer);
        return "province/province_index";
    }

    @GetMapping("/search")
    public String searchCustomerByNameContaining(@RequestParam("search") Optional<String> search, Model model, Pageable pageable) {
        Page<Customer> listCustomer;
        if (search.isPresent()) {
            listCustomer = this.customerService.findAllByNameContaining(search.get(), pageable);
            model.addAttribute("search", search.get());
        } else {
            listCustomer = this.customerService.findAll(pageable);
        }
        List<Province> listProvince = this.provinceService.findAll();

        model.addAttribute("customer", new Customer());
        model.addAttribute("listProvince", listProvince);
        model.addAttribute("listCustomer", listCustomer);

        return "index";
    }
}
