package com.blog_manager_update.controllers;

import com.blog_manager_update.models.Blog;
import com.blog_manager_update.services.BlogService;
import com.blog_manager_update.services.CategoryService;
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

    @GetMapping("/listSearchBlogs")
    public ModelAndView getBlogSearchList(@PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> search) {
        return new ModelAndView("admin/list_blog", "blogs", this.blogService.findAllByTitle(search.get(), pageable));
    }

    //    Handling
    @PostMapping("/createBlog")
    public String createBlog(Blog blog, RedirectAttributes redirectAttributes) {
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("createSuccess", "Created blog " + blog.getTitle() + " success!");
        return "redirect:/admin/listBlogs";
    }

    @PostMapping("/editBlog")
    public String editBlog(Blog blog, RedirectAttributes redirectAttributes) {
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("editSuccess", "Updated blog " + blog.getTitle() + " success!");
        return "redirect:/admin/listBlogs";
    }

    @PostMapping("/deleteBlog")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        String findTitleBlog = this.blogService.findById(id).getTitle();
        this.blogService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteSuccess", "Deleted blog " + findTitleBlog + " success!");
        return "redirect:/admin/listBlogs";
    }
}
