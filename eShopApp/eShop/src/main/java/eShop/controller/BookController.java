package eShop.controller;


import eShop.model.BillingInfo;
import eShop.model.Book;
import eShop.model.Cart;
import eShop.model.user.Address;
import eShop.model.user.Supplier;
import eShop.model.user.User;
import eShop.service.AuthorService;
import eShop.service.BillingInfoService;
import eShop.service.BookService;
import eShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    AuthorService authorService;

    @Autowired
    private BookService bookService;
    @Autowired
    private BillingInfoService billingInfoService;

    @Autowired


    private  UserService userService;

    @GetMapping(value = {"book/"})
    public String home() {
        return "book/index";
    }

    // SEARCH Use-Case
    @GetMapping(value = { "eshop/book/search" })
    public ModelAndView searchStudent(@RequestParam String search, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookService.getAllBooksQuickSearch(search));
        modelAndView.setViewName("book/list1");
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

        User activeUser = getActiveUser();
        Supplier supplier = new Supplier();

        supplier.setId(activeUser.getId());
        supplier.setEmail(activeUser.getEmail());

        book.setSupplier(supplier);
        Book savedBook = bookService.saveBook(book);

        return "redirect:/listBook";
    }

    @GetMapping(value = { "/listBook" })
    public ModelAndView showAllBooks( @Valid  @ModelAttribute("book")
                                                  Book book,
                                      BindingResult bindingResult,
                                      Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Book> listOfBooks = bookService.getAllBooks();
        modelAndView.addObject("books", bookService.getAllBooks());
        modelAndView.setViewName("book/list1");
        return modelAndView;
    }
    // show Registration Form
    @GetMapping(value={"/showBookForm"})
    public String newCustomerForm(Model model) {
        model.addAttribute("book", new Book());
         model.addAttribute("authors", authorService.getAllAuthors() );
        model.addAttribute("now", LocalDate.now());
        return "book/new";
    }

    public User getActiveUser()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if(principal instanceof UserDetails)
        {
            username =((UserDetails) principal).getUsername();
        }
        else
        {
            username = principal.toString();
        }
        System.out.println("hello");
        return userService.findByUsername(username);
    }

    //accept place order
    @GetMapping("book/placeorder")
    public String showPlaceOrder(){
        return "book/placeorder";
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
//        List<BillingInfo> billingAddresses = billingInfoService.getAllBillingAddresses(cart.getCustomer());
        Address billingAddress = new Address();
        Address shippingAddress = new Address();

        model.addAttribute("books", cart.getBooks());
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("billingAddress", billingAddress);
        model.addAttribute("shippingAddress", shippingAddress);
        return "book/placeorder";
    }
}
