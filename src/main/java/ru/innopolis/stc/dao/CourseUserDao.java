package ru.innopolis.stc.dao;

import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.User;

import java.util.List;

public interface CourseUserDao {
    List<User> findUsers(User user);

    List<Course> findCourses(Course course);
}
