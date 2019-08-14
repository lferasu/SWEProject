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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

//    @GetMapping("/addToCart")
//    public String displayAddToCart(Model model){
//        Book book = new Book();
//        model.addAttribute("book", book);
//        return "cart/addToCart";
//    }

    @GetMapping(value={"/addToCart"})
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
                cart.getBooks().add(book);
                ModelAndView modelAndView = new ModelAndView();
                //Getaneh added the following
                cart.setTotalPrice(bookService.calculateTotalPrice(cart.getBooks()));
                BillingInfo billingInfo = new BillingInfo();
                cart.getCustomer().getBillingInfos().add(billingInfo);


                modelAndView.addObject("cart",cart);

            //Getaneh additions end here

                modelAndView.setViewName("book/placeorder");
                return modelAndView;

    }

//    //accept place order
//    @GetMapping("book/placeorder")
//    public String showPlaceOrder(){
//        return "book/placeorder";
//    }

//    @PostMapping(value = {"/book/payment"})
//    public String placeOrder(
//            @Valid
//            @ModelAttribute("billingInfo")
//                    BillingInfo billingInfo,
//            BindingResult bindingResult,
//            Model model
//    ) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "book/placeorder";
//        }
//
////        Double totalPrice = bookService.calculateTotalPrice(cart.getBooks());
////        BillingInfo billingInfo = new BillingInfo();
////        Address billingAddress = new Address();
////        Address shippingAddress = new Address();
////
////        model.addAttribute("books", cart.getBooks());
////        model.addAttribute("totalPrice", totalPrice);
////        model.addAttribute("billingInfo", billingInfo);
//////        model.addAttribute("billingAddress", billingAddress);
//////        model.addAttribute("shippingAddress", shippingAddress);
//
//
//
//        return "redirect:/book/list";
//    }
}