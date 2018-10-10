package ru.innopolis.stc.pojo;

public class Teacher {
    private int id;
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

    public User getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public Teacher changeId(int id) {
        this.id = id;
        return this;
    }

    public Teacher changeUser(User user) {
        return new Teacher(id, user, description, photo);
    }

    public Teacher changeDescription(String description) {
        return new Teacher(id, user, description, photo);
    }

    public Teacher changePhoto(byte[] photo) {
        return new Teacher(id, user, description, photo);
    }
}
