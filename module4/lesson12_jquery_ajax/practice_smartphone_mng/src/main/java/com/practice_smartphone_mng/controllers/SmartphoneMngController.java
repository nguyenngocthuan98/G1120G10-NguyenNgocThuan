package com.practice_smartphone_mng.controllers;

import com.practice_smartphone_mng.models.Smartphone;
import com.practice_smartphone_mng.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SmartphoneMngController {
    @Autowired
    SmartphoneService smartphoneService;

    @GetMapping("/")
    public ModelAndView list(@PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("list", "smartphone", this.smartphoneService.findAll(pageable));
    }

    @GetMapping("/viewDetail")
    public ModelAndView viewDetail(@RequestParam Integer id) {
        return new ModelAndView("detail", "detailProduct", this.smartphoneService.findById(id));
    }

    @GetMapping("/viewCreate")
    public ModelAndView viewCreate() {
        return new ModelAndView("create", "createProduct", new Smartphone());
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Smartphone smartphone, RedirectAttributes redirectAttributes) {
        this.smartphoneService.save(smartphone);
        redirectAttributes.addFlashAttribute("messSuccess", "Created " + smartphone.getProducer() + " success!");
        return "redirect:/";
    }

    @GetMapping("/viewEdit")
    public ModelAndView viewEdit(@RequestParam Integer id) {
        return new ModelAndView("edit", "editProduct", this.smartphoneService.findById(id));
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Smartphone product, RedirectAttributes redirectAttributes) {
        this.smartphoneService.save(product);
        redirectAttributes.addFlashAttribute("messSuccess", "Updated " + product.getProducer() + " success!");
        return "redirect:/";
    }

    @GetMapping("/viewDelete")
    public ModelAndView viewDelete(@RequestParam Integer id) {
        return new ModelAndView("delete", "deleteProduct", this.smartphoneService.findById(id));
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messSuccess", "Deleted " + this.smartphoneService.findById(id).getProducer() + " success!");
        this.smartphoneService.deleteById(id);
        return "redirect:/";
    }
}
