package ru.innopolis.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc.bean.User;
import ru.innopolis.stc.service.IUserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "letCode!") String some, Model model) {
        model.addAttribute("some", some);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        return "hello";
    }

    @RequestMapping("/showUsers")
    public String showUsers(Model model) {
        List<User> users = (List<User>) userService.findAll();
        model.addAttribute("usersAll", users);
        return "show-users";
    }

}
