package ru.innopolis.stc.pojo;

public class Course {
    private int id;
    private boolean moderationStatus;
    private String name;
    private String description;
    private Teacher teacher;

    public Course() {
    }


    public Course(int id, boolean moderationstatus, String name, String description, Teacher teacher) {
        this.id = id;
        this.moderationStatus = moderationstatus;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public boolean isModerationStatus() {
        return moderationStatus;
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
        this.moderationStatus = moderationStatus;
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
}
