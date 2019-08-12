package eShop.controller;

import eShop.model.Book;
import eShop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class BookController {

    BookService bookService;

    @GetMapping(value = {"book/"})
    public String home() {
        return "book/index";
    }

    // Actually Register a Book
    @PostMapping(value = {"/registerProduct"})
    public String registerNewCustomer(
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
        model.addAttribute("product", new Book());
        // model.addAttribute("suppliers", supplierService.getAllSuppliers());
        model.addAttribute("now", LocalDate.now());
        return "product/new";
    }


}
