package eShop.utils;

import eShop.controller.DeliveryRequestController;
import eShop.model.Book;
import eShop.model.DeliveryRequest;
import eShop.model.user.User;
import eShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
public class Util {
    @Autowired
    private static UserService userService;

    @Autowired
    private static DeliveryRequestController deliveryRequestController;

    public static User getActiveUser()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if(principal instanceof UserDetails)
        {
            username =((UserDetails) principal).getUsername();
        }
        else
        {
            username = principal.toString();
        }
        System.out.println("hello");
        return userService.findByUsername(username);
    }


    public void sendDeliveryRequest(Book book, User user)
    {
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setEmail(book.getSupplier().getEmail());
        deliveryRequest.setName("eShope automatic email service");
        deliveryRequest.setRequestContent("The Book : " + book.toString() + " has been orderd by "
        + user.getFirstName() + " " + user.getLastName() +"\n" +
                "Delivery Address is " + userService.getAddress(user.getId()));
        deliveryRequestController.sendDeliveryRequest(deliveryRequest);
    }
}
