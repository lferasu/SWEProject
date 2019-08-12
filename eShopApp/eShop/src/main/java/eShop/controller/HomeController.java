package eShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/eshop", "/eshop/home", "/home"})
    public String showHomePage() {

        return "home/index";
    }

    @GetMapping(value = "login")
    public String login(){
        return "login";
    }

}
