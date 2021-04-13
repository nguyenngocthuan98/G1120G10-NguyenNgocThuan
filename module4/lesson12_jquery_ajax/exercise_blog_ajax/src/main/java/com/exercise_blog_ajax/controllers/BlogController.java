package com.exercise_blog_ajax.controllers;

import com.exercise_blog_ajax.models.Blog;
import com.exercise_blog_ajax.services.BlogService;
import com.exercise_blog_ajax.services.CategoryService;
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
@RequestMapping({"/admin"})
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    //    Get view
    @GetMapping("/listBlogs")
    public ModelAndView getBlogList(@PageableDefault(value = 5) Pageable pageable) {
        return new ModelAndView("admin/list_blog", "blogs", this.blogService.findAll(pageable));
    }

    @GetMapping("/viewDetailBlog")
    public ModelAndView getBlogDetail(@RequestParam Integer id) {
        return new ModelAndView("admin/detail_blog", "detail_blog", this.blogService.findById(id));
    }

    @GetMapping("/viewCreateBlog")
    public String getBlogCreate(Pageable pageable, Model model) {
        model.addAttribute("listCategory", this.categoryService.findAll(pageable));
        model.addAttribute("create_blog", new Blog());
        return "admin/create_blog";
    }

    @GetMapping("/viewEditBlog")
    public String getBlogEdit(@RequestParam Integer id, Pageable pageable, Model model) {
        model.addAttribute("listCategory", this.categoryService.findAll(pageable));
        model.addAttribute("edit_blog", this.blogService.findById(id));
        return "admin/edit_blog";
    }

    @GetMapping("/viewDeleteBlog")
    public ModelAndView getBlogDelete(@RequestParam Integer id) {
        return new ModelAndView("admin/delete_blog", "delete_blog", this.blogService.findById(id));
    }

    @GetMapping("/listSearchBlogs")
    public ModelAndView getBlogSearchList(@PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> search) {
        return new ModelAndView("admin/list_blog", "blogs", this.blogService.findAllByTitle(search.get(), pageable));
    }

    //    Handling
    @PostMapping("/createBlog")
    public String createBlog(Blog blog, RedirectAttributes redirectAttributes) {
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("messSuccess", "Created blog " + blog.getTitle() + " success!");
        return "redirect:/admin/listBlogs";
    }

    @PostMapping("/editBlog")
    public String editBlog(Blog blog, RedirectAttributes redirectAttributes) {
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("messSuccess", "Updated blog " + blog.getTitle() + " success!");
        return "redirect:/admin/listBlogs";
    }

    @PostMapping("/deleteBlog")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messSuccess", "Deleted blog " + this.blogService.findById(id).getTitle() + " success!");
        this.blogService.deleteById(id);
        return "redirect:/admin/listBlogs";
    }
}
