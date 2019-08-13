package eShop.controller;


import eShop.model.BillingInfo;
import eShop.model.Cart;
import eShop.model.user.Address;
import eShop.model.user.Customer;
import eShop.repository.BookRepository;
import eShop.model.Book;
import eShop.service.BillingInfoService;
import eShop.service.BookService;
import org.springframework.validation.BindingResult;
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
import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {


    @Autowired
    private BookService bookService;
    @Autowired
    private BillingInfoService billingInfoService;


    // SEARCH Use-Case
    @GetMapping(value = { "eshop/book/search" })
    public ModelAndView searchStudent(@RequestParam String search, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookService.getAllBooksQuickSearch(search));
        modelAndView.setViewName("book/list");
        return modelAndView;
    }

    // Actually Register a Book
    @PostMapping(value = {"/registerBook"})
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
        model.addAttribute("book", new Book());
        // model.addAttribute("suppliers", supplierService.getAllSuppliers());
        model.addAttribute("now", LocalDate.now());
        return "book/new";
    }

    //place order
    @PostMapping(value = {"/book/placeorder"})
    public String placeOrder(
        @Valid
        @ModelAttribute("cart")
                Cart cart,
        BindingResult bindingResult,
        Model model
    ) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("errors", bindingResult.getAllErrors());
                return "book/placeorder";
            }

        Double totalPrice = bookService.calculateTotalPrice(cart.getBooks());
        List<BillingInfo> billingAddresses = billingInfoService.getAllBillingAddresses(cart.getCustomer());
        Address shippingAddress = new Address();

        model.addAttribute("books", cart.getBooks());
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("billingAddresses", billingAddresses);
        model.addAttribute("shippingAddress", shippingAddress);
        return "book/c";

    }


}
