package ru.innopolis.stc.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "course_id")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Course course;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "home_work")
    private String homework;

    public Lesson() {
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id &&
                Objects.equals(course, lesson.course) &&
                Objects.equals(name, lesson.name) &&
                Objects.equals(content, lesson.content) &&
                Objects.equals(homework, lesson.homework);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, name, content, homework);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", course=" + course +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", homework='" + homework + '\'' +
                '}';
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


