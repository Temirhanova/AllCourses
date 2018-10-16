package ru.innopolis.stc.bean;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private String description;
    private byte[] photo;

    public Teacher() {
    }

    public Teacher(int id, User user, String description, byte[] photo) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                Objects.equals(user, teacher.user) &&
                Objects.equals(description, teacher.description) &&
                Arrays.equals(photo, teacher.photo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, user, description);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", photo=" + Arrays.toString(photo) +
                '}';
    }



/* public Teacher changeId(int id) {
        return new Teacher(id, user, description, photo);
    }

    public Teacher changeUser(User user) {
        return new Teacher(id, user, description, photo);
    }

    public Teacher changeDescription(String description) {
        return new Teacher(id, user, description, photo);
    }

    public Teacher changePhoto(byte[] photo) {
        return new Teacher(id, user, description, photo);
    }*/


}
