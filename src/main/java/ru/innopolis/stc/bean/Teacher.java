package ru.innopolis.stc.bean;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", unique = true, nullable = false, updatable = false)
    private User user;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private String photo;

    public Teacher() {
    }

    public Teacher(Long id, User user, String description, String photo) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) &&
                Objects.equals(user, teacher.user) &&
                Objects.equals(description, teacher.description) &&
                Objects.equals(photo, teacher.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, description, photo);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
