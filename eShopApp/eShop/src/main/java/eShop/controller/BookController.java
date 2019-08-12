package eShop.controller;


import eShop.repository.BookRepository;
import eShop.model.Book;
import eShop.service.AuthorService;
import eShop.service.BookService;
<<<<<<< HEAD
=======
import org.springframework.validation.BindingResult;
>>>>>>> e41923be3629420e3494f7f6d775f19577d157b2
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.time.LocalDate;


@Controller
public class BookController {



    @Autowired
    AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping(value = {"book/"})
    public String home() {
        return "book/index";
    }
    // SEARCH Use-Case
    @GetMapping(value = { "eshop/book/search" })
    public ModelAndView searchStudent(@RequestParam String search, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookService.getAllBooksQuickSearch(search));
        modelAndView.setViewName("book/list");
        return modelAndView;
    }

    // Actually Register a Book
    @PostMapping(value = "/registerBook")
    public String registerNewBook(
            @Valid
            @ModelAttribute("book")
                    Book book,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "Book/new";
        }
        bookService.saveBook(book);
        return "redirect:/listProduct";
    }


    // show Registration Form
    @GetMapping(value={"/showBookForm"})
    public String newCustomerForm(Model model) {
        model.addAttribute("book", new Book());
         model.addAttribute("authors", authorService.getAllAuthors() );
        model.addAttribute("now", LocalDate.now());
        return "Book/new";
    }


}
