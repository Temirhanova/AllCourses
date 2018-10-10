package ru.innopolis.stc.controller;

import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.services.CourseService;
import ru.innopolis.stc.services.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CourseServlet extends HttpServlet {

    private CourseService courseService;

    public CourseServlet() {
        this.courseService = new CourseServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courses = courseService.getAll();
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("WEB-INF/pages/all_courses.jsp").forward(req, resp);
    }
}
