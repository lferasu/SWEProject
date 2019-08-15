package eShop.controller;

import eShop.model.BillingInfo;
import eShop.model.Book;
import eShop.model.Cart;
import eShop.model.user.Address;
import eShop.model.user.Supplier1;
import eShop.model.user.User;
import eShop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import java.util.Arrays;

@Controller
public class BookController {
    private String noCover = "https://islandpress.org/sites/default/files/400px%20x%20600px-r01BookNotPictured.jpg";

    @Autowired
    AuthorService authorService;

    @Autowired
    UserService userService;

    @Autowired
    private BookService bookService;
    @Autowired
    private BillingInfoService billingInfoService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private static DeliveryRequestController deliveryRequestController;


    @GetMapping(value = {"book/"})
    public String home() {
        return "book/index";
    }
    // SEARCH Use-Case
    @GetMapping(value = { "eshop/book/search" })
    public ModelAndView searchStudent(@RequestParam (defaultValue = "0") int pageno, @RequestParam String search, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookService.getAllBooksQuickSearch(search, pageno));
        modelAndView.addObject("currentPageNo",pageno);
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

        if(book.getImage()==null || book.getImage().trim()=="")
        {
            book.setImage(noCover);
        }

        User activeUser = getActiveUser();
        Supplier1 supplier = new Supplier1();
        supplier.setId(activeUser.getId());
        supplier.setEmail(activeUser.getEmail());

        book.setSupplier(supplier);
        Book savedBook = bookService.saveBook(book);


        return "redirect:/listBook";
    }

    @GetMapping(value = { "/listBook" })
    public ModelAndView showAllBooks( @RequestParam (defaultValue = "0") int pageno) {

        ModelAndView modelAndView = new ModelAndView();
        Cart cart = new Cart();
        modelAndView.addObject("cart",cart);
        modelAndView.addObject("books",bookService.getAllBooksPaged(pageno));
        modelAndView.addObject("currentPageNo",pageno);
        modelAndView.setViewName("book/list1");
        return modelAndView;
    }

    // show Registration Form
    @GetMapping(value={"/showBookForm"})
    public String newCustomerForm(Model model) {
        model.addAttribute("book", new Book());
         model.addAttribute("authors", authorService.getAllAuthors() );
         model.addAttribute("categories", categoryService.getAllCategories());
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
        BillingInfo billingInfo = new BillingInfo();
        billingInfo.setCustomer(cart.getCustomer());
        cart.getCustomer().setBillingInfos(Arrays.asList(billingInfo));
//        Address billingAddress = new Address();
//        Address shippingAddress = new Address();
//        cart.getCustomer().setBillingAddress(billingAddress);
//        cart.getCustomer().setShippingAddress(shippingAddress);

        model.addAttribute("books", cart.getBooks());
        model.addAttribute("totalPrice", totalPrice);
//        model.addAttribute("billingInfo", billingInfo);
//        model.addAttribute("billingAddress", billingAddress);
//        model.addAttribute("shippingAddress", shippingAddress);
        return "book/placeorder";
    }

}
