package ru.innopolis.stc.dao;

import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.CourseUser;
import ru.innopolis.stc.pojo.User;
import java.util.List;

public interface CourseUserDao {
    List<CourseUser> findCourses(User user);

    public List<CourseUser> findUsers(Course course);
}
