package eShop.controller;

import eShop.model.Book;
import eShop.model.Cart;
import eShop.model.user.Customer;
import eShop.model.user.User;
import eShop.service.CartService;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private UserService userService;
    @PostMapping(value={"/addToCart"})
    public ModelAndView addBookToCart(@ModelAttribute("book") Book book,  BindingResult bindingResult, Model model){

Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

String userName;

if(principal instanceof UserDetails){
    userName=((UserDetails)principal).getUsername();
}
else{
    userName=principal.toString();
}
        User myUser=userService.findByUsername(userName);
        Cart cart = new Cart();
        Customer customer=(Customer)myUser;
        cart.setCustomer(customer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cart",cart);
        modelAndView.setViewName("book/placeorder");
        return modelAndView;
    }
}