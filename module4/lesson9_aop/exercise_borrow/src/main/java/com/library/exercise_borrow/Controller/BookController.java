package com.library.exercise_borrow.Controller;

import com.library.exercise_borrow.models.Book;
import com.library.exercise_borrow.services.BookService;
import com.library.exercise_borrow.services.exception.ZeroQuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    public ModelAndView getListBook() {
        return new ModelAndView("list", "listBook", this.bookService.findAll());
    }

    @GetMapping("/detailPage")
    public ModelAndView getBookDetailPage(@RequestParam Integer id) {
        return new ModelAndView("detail", "book", this.bookService.findById(id));
    }

    @PostMapping("/borrowBook")
    public String borrowBook(Book book, RedirectAttributes redirectAttributes) throws ZeroQuantityException {
        try {
            this.bookService.borrow(book);
            redirectAttributes.addFlashAttribute("messSuccess", book.getName() + " (id=" + book.getId() + ") " + "has been borrowed");
            return "redirect:/";
        } catch (ZeroQuantityException exception){
            redirectAttributes.addFlashAttribute("messSuccess", "Can't borrow, "+book.getName() + " (id=" + book.getId() + ") " + "is over");
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
