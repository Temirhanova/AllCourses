package ru.innopolis.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.bean.Lesson;
import ru.innopolis.stc.service.ICourseService;
import ru.innopolis.stc.service.ILessonService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

@Controller
public class LessonController {
    @Autowired
    private ICourseService courseService;

    @Autowired
    private ILessonService lessonService;

    @GetMapping("lesson/create")
    public String getCreateLessonPage(){
        return "create-lesson";
    }

    @GetMapping("lesson/create/{courseId}")
    public String getUpdateCoursePage(@PathVariable Integer courseId, Model model){
        Course course = courseService.getById(courseId);
        model.addAttribute("course", course);
        return "create-lesson";
    }

    @PostMapping("lesson/create/{courseId}")
    public String createPostLesson(
                               @RequestParam(name = "name", required = false, defaultValue = "") String name,
                               @RequestParam(name = "content", required = false, defaultValue = "") String content,
                               @RequestParam(name = "homework", required = false, defaultValue = "") String homework,
                               HttpServletRequest request,
                               @PathVariable Integer courseId) {
        Course course = courseService.getById(courseId);
        if(!name.equals("") && !content.equals("") && !homework.equals("")) {
            Lesson lesson = new Lesson(course, name, content, homework);
            lessonService.add(lesson);
        }
        return "redirect:/course/"+courseId;
    }

    @PostMapping("lesson/create")
    public String getUpdateLessonPage(
                                      @RequestParam @NotBlank String name,
                                      @RequestParam @NotBlank String content,
                                      @RequestParam @NotBlank String homework,
                                      HttpServletRequest request,
                                      @PathVariable Integer courseId, Model model){
        Course course = courseService.getById(courseId);
        model.addAttribute("course", course);
        model.addAttribute("lessons", lessonService.findAllByCourse(course));
        return "redirect:/courses";
    }
}
