package com.case_study.controllers;

import com.case_study.models.Contract;
import com.case_study.models.ContractDetail;
import com.case_study.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private AttachService attachService;

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

    @GetMapping("/viewContractDetail")
    public String viewDetailContractDetail(@RequestParam(name = "id") Integer id, Model model) {
        Contract contract = this.contractService.findById(id);
        model.addAttribute("contract", contract);
        model.addAttribute("listContractDetail", this.contractDetailService.findAllByContract(contract));
        return "contract_detail/detail";
    }

    @GetMapping("/viewCreateContractDetail")
    public String getCreateDetail(@RequestParam(name = "contractId") Integer id, Model model) {
        model.addAttribute("contract", this.contractService.findById(id));
        model.addAttribute("listAttachService", this.attachService.findAll());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract_detail/create";
    }

    @PostMapping("/createContractDetail")
    public String createContractDetail(@ModelAttribute(name = "contractDetail") ContractDetail contractDetail,
                                       @RequestParam(name = "contractId") Integer id, RedirectAttributes redirect) {
        contractDetail.setContract(this.contractService.findById(id));
        this.contractDetailService.save(contractDetail);
        redirect.addFlashAttribute("messSuccess", "Added successfully " +
                contractService.findById(id).getContractId());
        return "redirect:/contract/";
    }
}
