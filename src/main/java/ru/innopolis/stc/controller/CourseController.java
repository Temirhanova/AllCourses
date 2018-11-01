package ru.innopolis.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.bean.Teacher;
import ru.innopolis.stc.bean.User;
import ru.innopolis.stc.service.ICourseService;
import ru.innopolis.stc.service.ILessonService;
import ru.innopolis.stc.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ILessonService lessonService;

    @Autowired
    private IUserService userService;

    @PostMapping("course/create")
    public String createCourse(@RequestParam @NotBlank String name,
                               @RequestParam @NotBlank String description,
                               HttpServletRequest request) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        Course course = new Course(null, false, name, description, userService.findByMail(attr.getRequest().getUserPrincipal().getName()));
        courseService.add(course);
        return "redirect:/courses";
    }

    /**
     *  Редактирование/обновление курса
     */
    @PostMapping("course/{courseId}")
    public String updateCourse(@RequestParam @NotBlank String name,
                               @RequestParam @NotBlank String description,
                               @PathVariable Integer courseId,
                               HttpServletRequest request) {
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        Course course = courseService.getById(courseId);
        course.setName(name);
        course.setDescription(description);
        courseService.update(course);
        return "redirect:/courses";
    }

    @GetMapping("course/create")
    public String getCreateCoursePage(){
        return "create-course";
    }

    @GetMapping("/courses")
    public String getAllCourses(Model model){
        List<Course> courses = courseService.findAllByModerationstatus(true);
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/course/{courseId}")
    public String getCourse(@PathVariable Integer courseId, Model model) {
        Course course = courseService.getById(courseId);
        model.addAttribute("lessons", lessonService.findAllByCourse(course));
        model.addAttribute("course", course);
        return "course";
    }

    @GetMapping("/subscribe/{courseId}")
    public String subscribeCourse(Model model, @PathVariable Integer courseId) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        User user = userService.findByMail(attr.getRequest().getUserPrincipal().getName());
        Course course = courseService.getById(courseId);
        user.getCourses().add(course);
        userService.update(user);
        return "redirect:/courses";
    }

    @GetMapping("/mycourses")
    public String getMyCourses(Model model){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        User user = userService.findByMail(attr.getRequest().getUserPrincipal().getName());
        model.addAttribute("courses", user.getCourses());
        return "mycourses";
    }

    @GetMapping("/myAllCourses")
    public String getMyAllCourses(Model model){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        User user = userService.findByMail(attr.getRequest().getUserPrincipal().getName());
        model.addAttribute("courses", courseService.findAllByTeacher(user));
        return "myAllCourses";
    }

    @GetMapping("/unsubscribe/{courseId}")
    public String unSubscribeCourse(Model model, @PathVariable Integer courseId) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        Course course = courseService.getById(courseId);
        User user = userService.findByMail(attr.getRequest().getUserPrincipal().getName());
        user.getCourses().remove(course);
        userService.update(user);
        return "redirect:/mycourses";
    }

    @GetMapping("/moderateCourse")
    public String moderateCourse(Model model) {
        List<Course> courses = courseService.findAllByModerationstatus(false);
        model.addAttribute("courses", courses);
        return "courses";
    }
}