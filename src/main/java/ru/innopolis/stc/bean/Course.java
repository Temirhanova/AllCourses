package ru.innopolis.stc.bean;

import javax.persistence.*;
import java.util.Objects;

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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "course")
    private Lesson lesson;

/*  @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;*/

    public Course() {
    }

    public Course(Integer id, boolean moderationstatus, String name, String description, Teacher teacher) {
        this.id = id;
        this.moderationstatus = moderationstatus;
        this.name = name;
        this.description = description;
//        this.teacher = teacher;
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    /*public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }
    */
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
