package ru.innopolis.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.stc.bean.Teacher;
import ru.innopolis.stc.bean.User;
import ru.innopolis.stc.service.ITeacherService;
import ru.innopolis.stc.service.IUserService;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;
    private IUserService userService;

    @GetMapping("/teacher")
    public String getTeacher(Model model) {
        Teacher teacher = teacherService.getById(1L);
        User user = teacher.getUser();
        model.addAttribute("teacher", teacher);
        model.addAttribute("user", user);
        return "teacher";
    }
}
