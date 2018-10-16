package ru.innopolis.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.Teacher;
import ru.innopolis.stc.services.CourseService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("course/create")
    public String createCourse(@RequestParam @NotBlank String name,
                               @RequestParam @NotBlank String description,
                               HttpServletRequest request) {
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        Course course = new Course(0, false, name, description, teacher);
        courseService.add(course);
        return "redirect:/courses";
    }

    @GetMapping("course/create")
    public String getCreateCoursePage(){
        return "create-course";
    }

    @GetMapping("/courses")
    public String getAllCourses(Model model){
        List<Course> courses = courseService.getAll();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/course/{courseId}")
    public String getCourse(@PathVariable int courseId, Model model) {
        Course course = courseService.getById(courseId);
        model.addAttribute("course", course);
        return "course";
    }


}
