package ru.innopolis.stc.pojo;

public class Lesson {
    private int id;
    private Course course;
    private String name;
    private String content;
    private String homework;

    public Lesson(int id, Course course, String name, String content, String homework) {
        this.id = id;
        this.course = course;
        this.name = name;
        this.content = content;
        this.homework = homework;
    }

    public int getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getHomework() {
        return homework;
    }

    public Lesson changeId(int id) {
        return new Lesson(id, course, name, content, homework);
    }

    public Lesson changeCourse(Course course) {
        return new Lesson(id, course, name, content, homework);
    }

    public Lesson changeName(String name) {
        return new Lesson(id, course, name, content, homework);
    }

    public Lesson changeContent(String content) {
        return new Lesson(id, course, name, content, homework);
    }

    public Lesson changeHomework(String homework) {
        return new Lesson(id, course, name, content, homework);
    }
}
