package ru.innopolis.stc.dao;

import ru.innopolis.stc.pojo.Course;

import java.util.List;

public interface CourseDao {
    Course add(Course course);
    Course update(Course course);
    Course getById(int id);
    Course delete(Course course);
    List<Course> getAll();
}
