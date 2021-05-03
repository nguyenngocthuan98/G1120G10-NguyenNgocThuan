package com.exam.controllers;

import com.exam.models.Orders;
import com.exam.services.OrderService;
import com.exam.services.TypeProductService;
import com.exam.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TypeProductService typeProductService;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getList(@PageableDefault(value = 5) Pageable pageable, Model model) {
        model.addAttribute("order", this.orderService.findAll(pageable));
        return "list";
    }

    @GetMapping("/edit")
    public String getEdit(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("products", this.productService.findAll());
        model.addAttribute("typeProducts", this.typeProductService.findAll());
        model.addAttribute("order", this.orderService.findById(id));
        model.addAttribute("orderId", id);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("order") Orders orders, @RequestParam(name = "") Model model,
                       RedirectAttributes redirect) {
        this.orderService.save(orders);
        redirect.addFlashAttribute("messSuccess", "Updated successfully!");
        return "redirect:/";
    }
}
