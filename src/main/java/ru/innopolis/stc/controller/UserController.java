package ru.innopolis.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.stc.bean.User;
import ru.innopolis.stc.service.IUserService;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User userLogined, Model model) {
        model.addAttribute("userLogined", userLogined);
        return "start-page";
    }

    @GetMapping("/registration")
    public String registration(@AuthenticationPrincipal User userLogined, Model model) {
        model.addAttribute("userLogined", userLogined);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@AuthenticationPrincipal User userLogined, User userForm, Model model) {
        model.addAttribute("userLogined", userLogined);
        User userFromDb = userService.findByMail(userForm.getMail());
        if (userFromDb != null) {
            model.addAttribute("message", "User exists");
            return "/registration";
        }

        userForm.setActive(true);
        userService.addUser(userForm);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(@AuthenticationPrincipal User userLogined, Model model) {
        model.addAttribute("userLogined", userLogined);
        return "login";
    }

    @GetMapping("/users")
    public String showUsers(@AuthenticationPrincipal User userLogined, Model model) {
        model.addAttribute("usersAll", userService.findAll());
        return "users";
    }
}