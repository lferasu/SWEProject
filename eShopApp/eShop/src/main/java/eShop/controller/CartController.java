package eShop.controller;

import eShop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping(value = {"/", "/eshop", "/eshop/cart"})
    public String showAddtoCartPage(){
       return "cart/addToCart";
    }



}
