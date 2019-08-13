package eShop.controller;


import eShop.email.EmailCfg;
import eShop.model.DeliveryRequest;
import eShop.model.user.Supplier;
import eShop.model.user.User;
import eShop.repository.BookRepository;
import eShop.model.Book;
import eShop.security.UserPrincipal;
import eShop.service.AuthorService;
import eShop.service.BookService;
import eShop.service.UserService;
import eShop.utils.Util;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import java.util.List;


@Controller
public class BookController {



    @Autowired
    AuthorService authorService;

    @Autowired
    private BookService bookService;

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

        // Send Delivery Request ... to be removed

        return "redirect:/listBook";
    }

    @GetMapping(value = { "/listBook" })
    public ModelAndView showAllBooks( @Valid
                                          @ModelAttribute("book")
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


}
