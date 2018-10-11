package ru.innopolis.stc.services;

import ru.innopolis.stc.pojo.Course;
import java.util.List;

public interface CourseService {
    Course add(Course course);
    List<Course> getAll();
}
