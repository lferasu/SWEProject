package eShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping(value = {"book/"})
    public String home() {
        return "book/index";
    }

}
