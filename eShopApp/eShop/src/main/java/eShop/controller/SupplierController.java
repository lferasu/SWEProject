package eShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("supplier")
public class SupplierController {

    @GetMapping("index")
    public String index(){
        return "supplier/index";
    }

}
