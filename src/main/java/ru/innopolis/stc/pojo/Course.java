package ru.innopolis.stc.pojo;

public class Course {
    private int id;
    private boolean moderationstatus;
    private String name;
    private String description;
    private Teacher teacher;

    public Course() {
    }


    public Course(int id, boolean moderationstatus, String name, String description, Teacher teacher) {
        this.id = id;
        this.moderationstatus = moderationstatus;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    public Course(int id, boolean moderationstatus, String name, String description) {
        this.id = id;
        this.moderationstatus = moderationstatus;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public boolean isModerationStatus() {
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
        this.id = id;
        return this;
    }

    public Course changeModerationStatus(boolean moderationStatus) {
        this.moderationstatus = moderationStatus;
        return this;
    }

    public Course changeName(String name) {
        this.name = name;
        return this;
    }

    public Course changeDescription(String description) {
        this.description = description;
        return this;
    }

    public Course changeTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
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
