package ru.innopolis.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.stc.bean.Teacher;
import ru.innopolis.stc.bean.User;
import ru.innopolis.stc.service.ITeacherService;
import ru.innopolis.stc.service.IUserService;

@Controller
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;
    private IUserService userService;

    @GetMapping("/teacher")
    public String teacherProfile(@AuthenticationPrincipal User userLogined, Model model) {
        Teacher teacher = teacherService.findByUser(userLogined);
        model.addAttribute("teacher", teacher);
        return "teacher";
    }
}
