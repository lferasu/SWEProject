package eShop.controller;

import eShop.model.*;
import eShop.model.user.User;
import eShop.security.UserPrincipal;
import eShop.service.DeliveryInfoService;
import eShop.service.OrderService;
import eShop.service.PaymentRecordService;
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

@Controller
public class PaymentController {
    @Autowired
    private PaymentRecordService paymentRecordService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DeliveryInfoService deliveryInfoService;
    @Autowired
    private UserService userService;

//    @PostMapping(value = {"/payment"})
//    public String placeOrderConfirmationDidplay(
//            @Valid
//            @ModelAttribute("cart")
//                    Cart cart,
//            BindingResult bindingResult,
//            Model model
//    ) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "book/placeorder";
//        }
//
//        UserPrincipal principal= (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String userName;
//        User loggedInUser = principal.getUser();
//        loggedInUser.setShippingAddress(cart.getCustomer().getShippingAddress());
//        loggedInUser.setBillingAddress(cart.getCustomer().getBillingAddress());
//
//        userService.saveUser(loggedInUser);
//
//        Order order = orderService.saveOrder(cart);
//        PaymentRecord paymentRecord = paymentRecordService.savePaymentRecord(order);
//        DeliveryInfo deliveryInfo = deliveryInfoService.saveDeliveryInfo(order);
//
////        String delivery = "Your order: " + cart.getBook().getTitle() + " will be delivered on "
////                            + deliveryInfo.getExpectedArrival() + " (Customer Information"
////                            + cart.getCustomer().getFirstName() + " " + cart.getCustomer().getLastName() + ")"
////                            + " /n"
////                            + " Thank you for choosing us!";
////        model.addAttribute("delivery", delivery);
//
//        return "redirect:/book/confirmation";
//    }
//
//    @GetMapping(value = {"/book/confirmation"})
//    public String showConfirmation(Model model) {
//
//
//
//        return "book/confirmation";
//    }


}
