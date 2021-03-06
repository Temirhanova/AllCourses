package ru.innopolis.stc.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "moderation_status")
    private boolean moderationstatus;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Lesson> lessons;

    @JoinTable(name = "course_user",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ManyToMany
    private Set<User> users;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private User teacher;

    public Course() {
    }

    public Course(Integer id, boolean moderationstatus, String name, String description, User teacher) {
        this.id = id;
        this.moderationstatus = moderationstatus;
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Lesson> getLesson() {
        return lessons;
    }

    public void setLesson(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
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
                Objects.equals(description, course.description)
//                && Objects.equals(teacher, course.teacher)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moderationstatus, name, description);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", moderationstatus=" + moderationstatus +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
//                ", teacher=" + teacher +
                '}';
    }
}
