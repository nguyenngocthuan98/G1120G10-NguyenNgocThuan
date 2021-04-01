package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView getProductList() {
        List<Product> listProducts = productService.findAll();
        return new ModelAndView("index", "listProduct", listProducts);
    }

    @GetMapping("/createProductPage")
    public String getCreateProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/createProduct")
    public String createProduct(Product product, RedirectAttributes redirect) {
        productService.create(product);
        redirect.addFlashAttribute("messageCreate", "Created product success!");
        return "redirect:/";
    }

    @GetMapping("/{id}/updateProductPage")
    public ModelAndView getUpdateProductPage(@PathVariable int id) {
        return new ModelAndView("update", "product", productService.findById(id));
    }

    @PostMapping("/updateProduct")
    public String updateProduct(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("messageUpdate", "Updated product success!");
        return "redirect:/";
    }

    @GetMapping("/getDeleteProduct")
    public String getDeleteProduct(@RequestParam int id, RedirectAttributes redirect) {
        productService.delete(productService.findById(id).getId());
        redirect.addFlashAttribute("messageDelete", "Deleted product success!");
        return "redirect:/";
    }

    @GetMapping("/{id}/viewProductPage")
    public ModelAndView getProductPage(@PathVariable int id) {
        return new ModelAndView("view", "product", productService.findById(id));
    }
}
