package com.library.exercise_borrow.controllers;

import com.library.exercise_borrow.models.Book;
import com.library.exercise_borrow.services.BookService;
import com.library.exercise_borrow.services.exception.ZeroQuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String getListBook(HttpServletRequest httpServletRequest, Model model) {
        Integer count = (Integer) httpServletRequest.getSession().getAttribute("countSession");

        if (count == null) {
            count = 0;
        } else {
            count++;
        }
        httpServletRequest.getSession().setAttribute("countSession", count);

        model.addAttribute("listBook", this.bookService.findAll());
        model.addAttribute("countVisited", count);
        return "list";
    }

    @GetMapping("/detailPage")
    public ModelAndView getBookDetailPage(@RequestParam Integer id) {
        return new ModelAndView("detail", "book", this.bookService.findById(id));
    }

    @PostMapping("/borrowBook")
    public String borrowBook(Book book, RedirectAttributes redirectAttributes) {
        try {
            this.bookService.borrow(book);
            redirectAttributes.addFlashAttribute("messSuccess", book.getName() + " (id=" + book.getId() + ") " + "has been borrowed");
            return "redirect:/";
        } catch (ZeroQuantityException exception) {
            redirectAttributes.addFlashAttribute("messSuccess", "Can't borrow, " + book.getName() + " (id=" + book.getId() + ") " + "is over");
            return "redirect:/";
        }
    }

    @GetMapping("/payPage")
    public String getPayPage() {
        return "pay";
    }

    @PostMapping("/payBook")
    public String payBook(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        if (this.bookService.findBookId(id)) {
            Book book = this.bookService.findById(id);
            redirectAttributes.addFlashAttribute("messSuccess", book.getName() + " (id=" + book.getId() + ") " + "has been paid");
            this.bookService.pay(book);
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("mess", id + " not found");
            return "redirect:/payPage";
        }
    }
}
