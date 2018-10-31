package ru.innopolis.stc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.bean.Lesson;
import ru.innopolis.stc.bean.Teacher;
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
        model.addAttribute("lesson", course);
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


    @GetMapping("/lesson/{lessonId}/{courseId}")
    public String updateLesson(@PathVariable Integer lessonId,
                               @PathVariable Integer courseId,
                               Model model) {
        Lesson lesson = lessonService.getById(lessonId);
        model.addAttribute("lesson", lesson);
        return "lesson";
    }

    @PostMapping("/lesson/{lessonId}/{courseId}")
    public String updatePostLesson(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                                   @RequestParam(name = "content", required = false, defaultValue = "") String content,
                                   @RequestParam(name = "homework", required = false, defaultValue = "") String homework,
                                   @PathVariable Integer lessonId,
                                   @PathVariable Integer courseId,
                                   Model model) {
        Lesson lesson = lessonService.getById(4);
        lesson.setName(name);
        lesson.setContent(content);
        lesson.setHomework(homework);
        lessonService.update(lesson);
//        return "redirect:/course/" + courseId;
        model.addAttribute("lesson", lesson);
        return "redirect:/course/" + courseId;
    }

    @GetMapping("/lesson/delete/{lessonId}/{courseId}")
    public String deleteLesson(@PathVariable Integer lessonId,
                               @PathVariable Integer courseId,
                               Model model) {
        Lesson lesson = lessonService.getById(lessonId);
        lessonService.delete(lesson);
        System.out.println(" ----------- 7 ");
        return "redirect:/course/" + courseId;
    }

}
