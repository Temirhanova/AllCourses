package ru.innopolis.stc.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_user")
public class CourseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //TODO кажется можно удалить эту таблицу и поправить связи Course и User с поиошью аннотаций
    @Column(name = "course_id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Course course;

    @Column(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;

    public CourseUser() {
    }

    public CourseUser(int id, Course course, User user) {
        this.id = id;
        this.course = course;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseUser that = (CourseUser) o;
        return id == that.id &&
                Objects.equals(course, that.course) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, user);
    }

    @Override
    public String toString() {
        return "CourseUser{" +
                "id=" + id +
                ", course=" + course +
                ", user=" + user +
                '}';
    }
}

