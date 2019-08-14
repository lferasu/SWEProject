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
        return "redirect:index?search=" + user.getFirstName();
}

    @PostMapping(value = {"edit"})
    public String edit(@Valid @ModelAttribute("user") User user,
                       BindingResult bindingResult, Model model) {

//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            System.out.println(bindingResult.getAllErrors());
//            System.out.println(user);
//            return "admin/edit";
//        }
        //model.addAttribute("roles", Arrays.asList("ADMIN", "SUPPLIER", "CUSTOMER"));
        System.out.println("selected user: " + user);
        User tempUser = userService.findById(user.getId());
        System.out.println("*******************************"+ tempUser +"************************************************");
        Boolean flag = false;
        if(user.getFirstName() != tempUser.getFirstName()){
            tempUser.setFirstName(user.getFirstName()); flag=true;}
        if(user.getLastName() != tempUser.getLastName()){
            tempUser.setLastName(user.getLastName()); flag=true;}
        if(user.getRole() != tempUser.getRole() && user.getRole() != null){
            tempUser.setRole(user.getRole()); flag=true;}
        if(user.getActive() != tempUser.getActive() && user.getActive() != null){
            tempUser.setActive(user.getActive()); flag=true;}
        if (flag){

            try {
                userService.saveUser(tempUser);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return "redirect:index?search=" + tempUser.getFirstName();
    }

//    @GetMapping(value = {"/admin/delete/{id}"})
//    public String delete(@PathVariable Integer id, Model model) {
//        userService.(id);
//        return "redirect:/admin/index?search=";
//    }

}
