package com.blog.exercise_blog.controllers;


import com.blog.exercise_blog.models.Blog;
import com.blog.exercise_blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/admin"})
public class BlogController {
    @Autowired
    BlogService blogService;

    //    Get view
    @GetMapping("/")
    public ModelAndView getBlogList() {
        return new ModelAndView("admin/list_blog", "blogs", this.blogService.findAll());
    }

    @GetMapping("/viewDetailBlog")
    public ModelAndView getBlogDetail(@RequestParam Integer id) {
        return new ModelAndView("admin/detail_blog", "detail_blog", this.blogService.findById(id));
    }

    @GetMapping("/viewCreateBlog")
    public ModelAndView getBlogCreate() {
        return new ModelAndView("admin/create_blog", "create_blog", new Blog());
    }

    @GetMapping("/viewEditBlog")
    public ModelAndView getBlogEdit(@RequestParam Integer id) {
        return new ModelAndView("admin/edit_blog", "edit_blog", this.blogService.findById(id));
    }

//    Handling
    @PostMapping("/createBlog")
    public String createBlog(Blog blog, RedirectAttributes redirectAttributes) {
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("createSuccess", "Created blog " + blog.getTitle() + " success!");
        return "redirect:/admin/";
    }

    @PostMapping("/editBlog")
    public String editBlog(Blog blog, RedirectAttributes redirectAttributes) {
        this.blogService.save(blog);
        redirectAttributes.addFlashAttribute("editSuccess", "Updated blog " + blog.getTitle() + " success!");
        return "redirect:/admin/";
    }

    @PostMapping("/deleteBlog")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        this.blogService.deleteById(id);
        String findBlog = this.blogService.findById(id).getTitle();
        redirectAttributes.addFlashAttribute("deleteSuccess", "Updated blog " + findBlog + " success!");
        return "redirect:/admin/";
    }
}
