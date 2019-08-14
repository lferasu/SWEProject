package eShop.controller;

import eShop.model.user.Role;
import eShop.model.user.User;
import eShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(@RequestParam(value = "search", required = false) String searchText, Model model) {
        List<User> searchResults = null;
        try {
            searchResults = userService.findAllUsersByText(searchText);
            System.out.println(searchResults.get(0));

        } catch (Exception ex) {
            System.out.println(ex);
        }
        model.addAttribute("search", searchResults);
        return "admin/index";
    }

//------------------EDIT USER --------------------------------------------------------
    @GetMapping(value = {"edit/{id}"})
    public String edit(@PathVariable Integer id, Model model) {
            User user = userService.findById(id);
        System.out.println("selected user: " + user);
        if (user != null) {
            model.addAttribute("user", user);
            return "admin/edit";
        }
        return "redirect:admin/index?search=";
}

    @PostMapping(value = {"edit"})
    public String edit(@Valid @ModelAttribute("user") User user,
                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/edit";
        }
        model.addAttribute("roles", Arrays.asList("ADMIN", "SUPPLIER", "CUSTOMER"));
        System.out.println("*******************************"+Role.CUSTOMER.toString()+"************************************************");
        if(!user.getRole().toString().equalsIgnoreCase("")) {
//            try {
                userService.saveUser(user);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
        }
        return "redirect:admin/index?search=";
    }

//    @GetMapping(value = {"/admin/delete/{id}"})
//    public String delete(@PathVariable Integer id, Model model) {
//        userService.(id);
//        return "redirect:/admin/index?search=";
//    }

}
