package com.case_study.controllers;

import com.case_study.models.Contract;
import com.case_study.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/")
    public ModelAndView getHomeContract() {
        return new ModelAndView("contract/list", "contracts", this.contractService.findAll());
    }

    @GetMapping("/viewCreateContract")
    public String getCreate(Model model, Pageable pageable) {
        model.addAttribute("customer", customerService.findAll(pageable));
        model.addAttribute("employee", employeeService.findAll(pageable));
        model.addAttribute("service", serviceService.findAll());
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("contract") Contract contract, RedirectAttributes redirect) {
        contract.setContractTotalMoney(contractService.totalMoney(contract));
        this.contractService.save(contract);
        redirect.addFlashAttribute("messSuccess", "Added successfully" + " CONTRACT");
        return "redirect:/contract/";
    }
}
