package eShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class ChartController {

    @RequestMapping(value = "chart", method= RequestMethod.GET)
    public String chart(Model model) {

        //first, add the regional sales
        Integer science = 17089;
        Integer nobel = 10603;
        Integer art = 5223;
        Integer meditation = 10111;

        model.addAttribute("science", science);
        model.addAttribute("meditation", meditation);
        model.addAttribute("art", art);
        model.addAttribute("nobel", nobel);

        //now add sales by lure type
        List<Integer> supplierA = Arrays.asList(4074, 3455, 4112);
        List<Integer> supplierB = Arrays.asList(3222, 3011, 3788);
        List<Integer> supplierC = Arrays.asList(7811, 7098, 6455);

        model.addAttribute("supplierA", supplierA);
        model.addAttribute("supplierB", supplierB);
        model.addAttribute("supplierC", supplierC);

        return "chart";
    }


}