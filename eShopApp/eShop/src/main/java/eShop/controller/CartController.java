package eShop.controller;

import eShop.model.*;
import eShop.model.user.Address;
import eShop.model.user.User;
import eShop.security.UserPrincipal;
import eShop.service.*;

import eShop.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller

public class CartController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private PaymentRecordService paymentRecordService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DeliveryInfoService deliveryInfoService;

    @Autowired
    CartService cartService;

    @Autowired
    private static DeliveryRequestController deliveryRequestController;

    @Autowired
    private EmailServiceImpl emailService;


    @GetMapping(value= {"/addToCart/{id}" })

            public String addBookToCart(@PathVariable Integer id, Model model){

            Cart cart=new Cart();
            Book book = bookService.getBookById(id);
            book.setCart(cart);
            List<Book> books = new ArrayList<>();
            books.add(book);

            UserPrincipal principal= (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User loggedInUser = principal.getUser();
            User customer = loggedInUser;
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            cart.setSessionId(sessionId);
            cart.setBooks(books);
            //checking the address in the database

            if(customer.getBillingAddress() == null) {

                Address billingAddress = new Address();
                Address shippingAddress = new Address();
                customer.setBillingAddress(billingAddress);
                customer.setShippingAddress(shippingAddress);
            }


            cart.setCustomer(customer);
           // ModelAndView modelAndView = new ModelAndView();
            //Getaneh added the following
            cart.setTotalPrice(bookService.calculateTotalPrice(cart.getBooks()));
 //           BillingInfo billingInfo = new BillingInfo();
            customer.setBillingInfos(Arrays.asList(new BillingInfo(1234, "dggh", LocalDate.now(), 123, customer)));
            Cart savedCart = cartService.saveCart(cart);
            model.addAttribute("cart", savedCart);
            //            customer.getBillingInfos().add(billingInfo);

//            modelAndView.addObject("cart", cart);
//
//    //Getaneh additions end here
//           modelAndView.setViewName("book/placeorder");
//           return modelAndView;


            return "Book/placeorder";



    }

    @PostMapping(value = {"/addToCart"})
    public String placeOrderConfirmationDisplay(
            @Valid

            @ModelAttribute("cart")
            @RequestBody Cart cart,

            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());

            return "Book/placeorder";
        }

        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        cart = cartService.findCartBySessionId(sessionId);
        UserPrincipal principal= (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = principal.getUser();


        loggedInUser.setShippingAddress(cart.getCustomer().getShippingAddress());
        loggedInUser.setBillingAddress(cart.getCustomer().getBillingAddress());

       // userService.saveUser(loggedInUser);

        Order order = orderService.saveOrder(cart);
      //  PaymentRecord paymentRecord = paymentRecordService.savePaymentRecord(order);
        DeliveryInfo deliveryInfo = deliveryInfoService.saveDeliveryInfo(order);


        for (Book book : cart.getBooks())
        {
            String delivery = "Your order: " + book.getTitle() + " will be delivered on "
                    + deliveryInfo.getExpectedArrival() + " (Customer Information"
                    + cart.getCustomer().getFirstName() + " " + cart.getCustomer().getLastName() + ")"
                    + " /n"
                    + " Thank you for choosing us!";

            sendEmail(book,loggedInUser,delivery);

        }


        return "redirect:/Book/confirmation";
    }

    @GetMapping(value = {"/Book/confirmation"})

    public String showConfirmation(Model model) {



        return "book/confirmation";
    }


    public void sendEmail(Book book, User user, String message)
    {
        SimpleMailMessage registrationEmail = new SimpleMailMessage();
        registrationEmail.setTo(user.getEmail());
        registrationEmail.setSubject("Delivery Request");
        registrationEmail.setText(message);
        registrationEmail.setFrom("noreply@cs.mum.edu");

        emailService.sendEmail(registrationEmail);
    }

    }
