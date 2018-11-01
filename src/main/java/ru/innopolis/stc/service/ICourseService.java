package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.bean.User;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    List<Course> findAllByModerationstatus(Boolean moderationstatus);
    List<Course> findAllByTeacher(User teacher);
    Course add(Course course);
    Course getById(Integer courseId);
    void update(Course course);
    void save(Course course);

}
