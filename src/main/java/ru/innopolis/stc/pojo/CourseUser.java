package ru.innopolis.stc.pojo;

public class CourseUser {
    private Course course;
    private User user;

    public CourseUser(Course course, User user) {
        this.course = course;
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public User getUser() {
        return user;
    }

    public CourseUser changeCourse(Course course) {
        return new CourseUser(course, user);
    }

    public CourseUser changeUser(User user) {
        return new CourseUser(course, user);
    }
}
