package eShop.controller;

import eShop.model.user.User;
import eShop.security.UserPrincipal;
import eShop.security.UserPrincipalDetailsService;
import eShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Show Profile-------------------------------------
    @GetMapping(value = {"index", "signin"})
    public String showProfileForm(Model model){
        UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userPrincipal.getUser();
        if(loggedInUser == null) return "redirect:/login";
        model.addAttribute("user", loggedInUser);
        return "profile/index";
    }
    //Edit Profile-------------------------------------
    @PostMapping("index")
    public String saveForm(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "index";
        }
        UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = userPrincipal.getUser();
        loggedInUser.setEmail(user.getEmail());
        loggedInUser.setFirstName(user.getFirstName());
        loggedInUser.setLastName(user.getLastName());
        if(!user.getPassword().equals(""))
            loggedInUser.setPassword(passwordEncoder.encode(user.getPassword()));

        try {
            userService.saveUser(loggedInUser);
        }
        catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/";
    }
}
