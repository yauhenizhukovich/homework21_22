package com.gmail.supersonicleader.mvc.web.controller;

import javax.validation.Valid;

import com.gmail.supersonicleader.mvc.service.UserService;
import com.gmail.supersonicleader.mvc.service.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute(name = "user") @Valid UserDTO user,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        } else {
            boolean isAdded = userService.addUser(user);
            if (!isAdded) {
                model.addAttribute("message", "User with this username already exists");
                return "register";
            }
            String username = user.getUsername();
            model.addAttribute("message",
                    username + ", you successfully registered. Now enter your username and password to continue");
            return "login";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
