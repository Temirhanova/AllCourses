package ru.innopolis.stc.controller;

import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.Teacher;
import ru.innopolis.stc.services.CourseService;
import ru.innopolis.stc.services.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCourseServlet extends HttpServlet {

    private CourseService courseService;

    public CreateCourseServlet() {
        this.courseService = new CourseServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/create-course.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Integer teacherId = Integer.valueOf(req.getParameter("teacherId"));

        Course course = new Course()
                .changeName(name)
                .changeDescription(description)
                .changeTeacher(new Teacher().changeId(teacherId))
                .changeModerationStatus(false);
        courseService.add(course);
        resp.sendRedirect("/courses");
    }
}