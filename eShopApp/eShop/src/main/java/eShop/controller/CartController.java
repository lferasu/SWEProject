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

//    @PostMapping(value={"/addToCart"})




//    // ADD-NEW Use-Case
//    @PostMapping(value = { "/emarket/product/save" })
//    public String addNewProduct(@Valid @ModelAttribute("student") Product product, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "/eRegistrar/product/edit";
//        }
//        product = productService.save(product);
//        return "redirect:/emarket/product/list";
//    }


}
