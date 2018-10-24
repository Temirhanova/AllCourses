package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.bean.User;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course add(Course course);
    Course getById(Integer courseId);
    void update(Course course);
}
