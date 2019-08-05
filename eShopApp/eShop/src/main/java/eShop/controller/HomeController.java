package eShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"eshop", "eshop/home","/"})
    public String home() {
        return "home/index";
    }

}
