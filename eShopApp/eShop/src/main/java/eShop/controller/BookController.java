package eShop.controller;

import eShop.repository.BookRepository;
import eShop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = {"book/"})
    public String home() {
        return "book/index";
    }
    // SEARCH Use-Case
    @GetMapping(value = { "eshop/Book/search" })
    public ModelAndView searchStudent(@RequestParam String search, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", bookService.getAllBooksQuickSearch(search));
        modelAndView.setViewName("Book/search");
        return modelAndView;
    }

}
