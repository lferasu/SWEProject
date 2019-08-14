package eShop.controller;

import eShop.model.BillingInfo;
import eShop.model.Book;
import eShop.model.Cart;
import eShop.model.user.Address;
import eShop.model.user.Customer;
import eShop.model.user.User;
import eShop.service.BookService;
import eShop.service.CartService;
import eShop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller

public class CartController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;


    @GetMapping(value= {"/addToCart/{id}"})
            public ModelAndView addBookToCart(@PathVariable Integer id, Model model){

            Book book = bookService.getBookById(id);

            Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            String userName;


            if(principal instanceof UserDetails){
            userName = ((UserDetails) principal).getUsername();
            }
            else{
            userName=principal.toString();
            }
            User myUser=userService.findByUsername(userName);
            Cart cart=new Cart();
            Customer customer=(Customer) myUser;
            cart.setCustomer(customer);
            cart.setBooks(Arrays.asList(book));
            ModelAndView modelAndView = new ModelAndView();
            //Getaneh added the following
            cart.setTotalPrice(bookService.calculateTotalPrice(cart.getBooks()));
            BillingInfo billingInfo = new BillingInfo();
            cart.getCustomer().getBillingInfos().add(billingInfo);


            modelAndView.addObject("cart", cart);

    //Getaneh additions end here

                modelAndView.setViewName("book/placeorder");
                return modelAndView;

}
    }
