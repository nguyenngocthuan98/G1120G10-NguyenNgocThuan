package com.case_study.controllers;

import com.case_study.models.Service;
import com.case_study.services.RentTypeService;
import com.case_study.services.ServiceService;
import com.case_study.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("/")
    public String getServices(Model model) {
        model.addAttribute("serviceType", this.serviceTypeService.findAll());
        model.addAttribute("rentType", this.rentTypeService.findAll());
        model.addAttribute("services", this.serviceService.findAll());
        return ("service/list");
    }

    @GetMapping("/viewDetail")
    public String viewDetail(@ModelAttribute("id") String id, Model model) {
        model.addAttribute("serviceType", this.serviceTypeService.findAll());
        model.addAttribute("rentType", this.rentTypeService.findAll());
        model.addAttribute("services", this.serviceService.findById(id));
        return ("service/detail");
    }

    @GetMapping("/viewCreate")
    public String viewCreate(Model model) {
        model.addAttribute("serviceType", this.serviceTypeService.findAll());
        model.addAttribute("rentType", this.rentTypeService.findAll());
        model.addAttribute("service", new Service());
        return "service/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("service") Service service, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        this.serviceService.checkServiceId(service, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceType", this.serviceTypeService.findAll());
            model.addAttribute("rentType", this.rentTypeService.findAll());
            model.addAttribute("service", service);
            return "service/create";
        }
        this.serviceService.save(service);
        redirectAttributes.addFlashAttribute("messSuccess", "Added successfully: " + service.getServiceName());
        return "redirect:/service/";
    }
}
