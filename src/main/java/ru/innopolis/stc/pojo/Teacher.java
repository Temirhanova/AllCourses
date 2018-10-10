package ru.innopolis.stc.pojo;

public class Teacher {
    private int id;
    private User user;
    private String description;
    private String photo;

    public Teacher(int id, User user, String description, String photo) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public Teacher changeId(int id) {
        return new Teacher(id, user, description, photo);
    }

    public Teacher changeUser(User user) {
        return new Teacher(id, user, description, photo);
    }

    public Teacher changeDescription(String description) {
        return new Teacher(id, user, description, photo);
    }

    public Teacher changePhoto(String photo) {
        return new Teacher(id, user, description, photo);
    }
}
