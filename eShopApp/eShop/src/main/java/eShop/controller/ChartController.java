package eShop.controller;

import eShop.model.user.User;
import eShop.service.PaymentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class ChartController {

    //@Autowired
    private PaymentRecordService paymentRecordService;

    @RequestMapping(value = "chart", method= RequestMethod.GET)
    public String chart(Model model) {

        //first, add the categories sales
        Integer science = 17089;
        Integer nobel = 10603;
        Integer art = 5223;
        Integer meditation = 10111;

        model.addAttribute("science", science);
        model.addAttribute("meditation", meditation);
        model.addAttribute("art", art);
        model.addAttribute("nobel", nobel);

        //now add sales by supplier
        List<Integer> supplierA = Arrays.asList(4074, 3455, 4112);
        List<Integer> supplierB = Arrays.asList(3222, 3011, 3788);
        List<Integer> supplierC = Arrays.asList(7811, 7098, 6455);

//-------------------------------------------------------

//        try {
//            LinkedHashMap<User, Double> topSuppliersThreeMonthAgo = paymentRecordService.topSupplierBySales(3);
//            LinkedHashMap<User, Double> topSuppliersTwoMonthAgo = paymentRecordService.topSupplierBySales(2);
//            LinkedHashMap<User, Double> topSuppliersOneMonthAgo = paymentRecordService.topSupplierBySales(1);
//
//            ArrayList<User> suppliersThree = new ArrayList<>(topSuppliersThreeMonthAgo.keySet());
//            ArrayList<Double> amountsThree = new ArrayList<>(topSuppliersThreeMonthAgo.values());
//
//            ArrayList<User> suppliersTwo = new ArrayList<>(topSuppliersTwoMonthAgo.keySet());
//            ArrayList<Double> amountsTwo = new ArrayList<>(topSuppliersTwoMonthAgo.values());
//
//            ArrayList<User> suppliersOne = new ArrayList<>(topSuppliersOneMonthAgo.keySet());
//            ArrayList<Double> amountsOne = new ArrayList<>(topSuppliersOneMonthAgo.values());
//
//            List<Double> supplierA = Arrays.asList(amountsThree.get(0), amountsTwo.get(0), amountsOne.get(0));
//            List<Double> supplierB = Arrays.asList(amountsThree.get(1), amountsTwo.get(1), amountsOne.get(1));
//            List<Double> supplierC = Arrays.asList(amountsThree.get(2), amountsTwo.get(2), amountsOne.get(2));
//        }catch (Exception e){ System.out.println(e); }

//        Double totalSalesAmount = paymentRecordService.totalSalesAmount();
//        model.addAttribute("totalSalesAmount", totalSalesAmount);

//-----------------------------------------------------------------

        model.addAttribute("supplierA", supplierA);
        model.addAttribute("supplierB", supplierB);
        model.addAttribute("supplierC", supplierC);
        model.addAttribute("totalSalesAmount", supplierA);

        return "chart";
    }


}