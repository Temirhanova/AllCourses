package ru.innopolis.stc.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "moderation_status")
    private boolean moderationstatus;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "teacher_id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isModerationstatus() {
        return moderationstatus;
    }

    public void setModerationstatus(boolean moderationstatus) {
        this.moderationstatus = moderationstatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                moderationstatus == course.moderationstatus &&
                Objects.equals(name, course.name) &&
                Objects.equals(description, course.description) &&
                Objects.equals(teacher, course.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moderationstatus, name, description, teacher);
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

/*
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
        */


}
