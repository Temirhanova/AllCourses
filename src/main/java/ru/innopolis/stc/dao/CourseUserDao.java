package ru.innopolis.stc.dao;

import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.User;

import java.util.List;

public interface CourseUserDao {
    List<User> findUsers(Course course, User user);

    List<Course> findCourses(Course course, User user);
}
