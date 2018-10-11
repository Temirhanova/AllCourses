package ru.innopolis.stc.pojo;

public class Course {
    private int id;
    private boolean moderationstatus;
    private String name;
    private String description;
    private Teacher teacher;

    public Course(int id, boolean moderationstatus, String name, String description, Teacher teacher) {
        this.id = id;
        this.moderationstatus = moderationstatus;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public boolean isModerationstatus() {
        return moderationstatus;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course changeId(int id) {
        return new Course(id, moderationstatus, name, description, teacher);
    }

    public Course changeModerationstatus(boolean moderationstatus) {
        return new Course(id, moderationstatus, name, description, teacher);
    }

    public Course changeName(String name) {
        return new Course(id, moderationstatus, name, description, teacher);
    }

    public Course changeDescription(String description) {
        return new Course(id, moderationstatus, name, description, teacher);
    }

    public Course changeTeacher(Teacher teacher) {
        return new Course(id, moderationstatus, name, description, teacher);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", moderationstatus=" + moderationstatus +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
