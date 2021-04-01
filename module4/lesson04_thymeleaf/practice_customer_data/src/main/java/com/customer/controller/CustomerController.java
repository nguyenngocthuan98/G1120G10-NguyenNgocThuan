package com.customer.controller;

import com.customer.model.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView getCustomerList() {
        List<Customer> listCus = customerService.findAll();
        return new ModelAndView("index", "listCustomers", listCus);
    }

    @GetMapping("/createCustomerPage")
    public String getCreateCustomerPage(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.create(customer);
        redirect.addFlashAttribute("messageCreate", "Created customer success!");
        return "redirect:/";
    }

    @GetMapping("/{id}/updateCustomerPage")
    public ModelAndView getUpdateCustomerPage(@PathVariable int id) {
        return new ModelAndView("update", "customer", customerService.findById(id));
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.update(customer.getId(), customer);
        redirect.addFlashAttribute("messageUpdate", "Updated customer success!");
        return "redirect:/";
    }

    @GetMapping("/{id}/getDeleteCustomer")
    public String getDeleteCustomer(@PathVariable int id, RedirectAttributes redirect) {
        customerService.delete(customerService.findById(id).getId());
        redirect.addFlashAttribute("messageDelete", "Deleted customer success!");
        return "redirect:/";
    }

    @GetMapping("/{id}/viewCustomerPage")
    public ModelAndView getCustomerPage(@PathVariable int id) {
        return new ModelAndView("view", "customer", customerService.findById(id));
    }
}
