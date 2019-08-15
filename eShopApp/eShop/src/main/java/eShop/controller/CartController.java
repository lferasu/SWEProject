package eShop.controller;

import eShop.model.*;
import eShop.model.user.Address;
import eShop.model.user.User;
import eShop.security.UserPrincipal;
import eShop.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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



    @GetMapping(value= {"/addToCart/{id}" })
            public ModelAndView addBookToCart(@PathVariable Integer id, Model model){

            Cart cart=new Cart();
            Book book = bookService.getBookById(id);
            List<Book> books = new ArrayList<>();
            books.add(book);

            UserPrincipal principal= (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User loggedInUser = principal.getUser();
            User customer = loggedInUser;

            cart.setBooks(books);
            //User customer=(User) myUser;
            //checking the address in the database

            if(customer.getBillingAddress() == null) {

                Address billingAddress = new Address();
                Address shippingAddress = new Address();
                customer.setBillingAddress(billingAddress);
                customer.setShippingAddress(shippingAddress);
            }

            
            cart.setCustomer(customer);
            System.out.println("***************in the cart:************* " + cart.getCustomer());
            ModelAndView modelAndView = new ModelAndView();
            //Getaneh added the following
            cart.setTotalPrice(bookService.calculateTotalPrice(cart.getBooks()));
 //           BillingInfo billingInfo = new BillingInfo();
            customer.setBillingInfos(Arrays.asList(new BillingInfo(1234, "dggh", LocalDate.now(), 123, customer)));
//            customer.getBillingInfos().add(billingInfo);

            modelAndView.addObject("cart", cart);

    //Getaneh additions end here

                modelAndView.setViewName("Book/placeorder");
                return modelAndView;

}
//codes from payment controller

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

        UserPrincipal principal= (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = principal.getUser();
        System.out.println(loggedInUser.toString());

        //cart.setCustomer(loggedInUser);
        System.out.println(cart.getCustomer().getShippingAddress() + "+++++++++++++++++++++++++++++++++++++++++++++");
        loggedInUser.setShippingAddress(cart.getCustomer().getShippingAddress());
        loggedInUser.setBillingAddress(cart.getCustomer().getBillingAddress());

        userService.saveUser(loggedInUser);
        Order order = orderService.saveOrder(cart);
        PaymentRecord paymentRecord = paymentRecordService.savePaymentRecord(order);
        DeliveryInfo deliveryInfo = deliveryInfoService.saveDeliveryInfo(order);

//        String delivery = "Your order: " + cart.getBook().getTitle() + " will be delivered on "
//                            + deliveryInfo.getExpectedArrival() + " (Customer Information"
//                            + cart.getCustomer().getFirstName() + " " + cart.getCustomer().getLastName() + ")"
//                            + " /n"
//                            + " Thank you for choosing us!";
//        model.addAttribute("delivery", delivery);

        return "redirect:/Book/confirmation";
    }

    @GetMapping(value = {"/Book/confirmation"})
    public String showConfirmation(Model model) {



        return "book/confirmation";
    }

    }
