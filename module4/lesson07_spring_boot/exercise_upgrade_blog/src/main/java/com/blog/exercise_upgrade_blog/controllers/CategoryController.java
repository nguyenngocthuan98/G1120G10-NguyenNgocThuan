package com.blog.exercise_upgrade_blog.controllers;

import com.blog.exercise_upgrade_blog.models.Category;
import com.blog.exercise_upgrade_blog.services.CategoryService;
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

@Controller
@RequestMapping({"/admin"})
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //    Get view
    @GetMapping("/listCategories")
    public ModelAndView getCategoryList(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("admin/list_category", "categories", this.categoryService.findAll(pageable));
    }

    @GetMapping("/viewDetailCategory")
    public ModelAndView getCategoryDetail(@RequestParam Integer id) {
        return new ModelAndView("admin/detail_category", "detail_category", this.categoryService.findById(id));
    }

    @GetMapping("/viewCreateCategory")
    public String getCategoryCreate(Model model) {
        model.addAttribute("create_category", new Category());
        return "admin/create_category";
    }

    @GetMapping("/viewEditCategory")
    public String getCategoryEdit(@RequestParam Integer id, Model model) {
        model.addAttribute("edit_category", this.categoryService.findById(id));
        return "admin/edit_category";
    }

    //    Handling
    @PostMapping("/createCategory")
    public String createCategory(Category category, RedirectAttributes redirectAttributes) {
        this.categoryService.save(category);
        redirectAttributes.addFlashAttribute("createSuccess", "Created category " + category.getName() + " success!");
        return "redirect:/admin/listCategories";
    }

    @PostMapping("/editCategory")
    public String editCategory(Category category, RedirectAttributes redirectAttributes) {
        this.categoryService.save(category);
        redirectAttributes.addFlashAttribute("editSuccess", "Updated category " + category.getName() + " success!");
        return "redirect:/admin/listCategories";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        String findName = this.categoryService.findById(id).getName();
        this.categoryService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteSuccess", "Deleted category " + findName + " success!");
        return "redirect:/admin/listCategories";
    }
}
