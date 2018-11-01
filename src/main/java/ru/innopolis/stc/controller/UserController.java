package ru.innopolis.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc.bean.Role;
import ru.innopolis.stc.bean.User;
import ru.innopolis.stc.service.IUserService;

import java.util.Collections;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/")
    public String index() {
        return "start-page";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User userForm, Model model) {
        User userFromDb = userService.findByMail(userForm.getMail());
        if (userFromDb != null) {
            model.addAttribute("message", "User exists");
            return "/registration";
        }
        userForm.setActive(true);
        userForm.setRoles(Collections.singleton(Role.USER));
        userService.addUser(userForm);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/users")
    public String showUsers(@AuthenticationPrincipal User userLogined, Model model) {
        model.addAttribute("usersAll", userService.findAll());
        return "users";
    }
}