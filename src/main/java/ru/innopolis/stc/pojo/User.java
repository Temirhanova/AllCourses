package ru.innopolis.stc.pojo;

public class User {
    public static final int GUEST = 1;
    public static final int STUDENT = 2;
    public static final int TEACHER = 3;
    public static final int ADMINISTRATOR = 4;

    private int id;
    private int role;
    private String mail;
    private String pass;
    private String firstName;
    private String lastName;

    public User(int id, int role, String mail, String pass, String firstName, String lastName) {
        this.id = id;
        this.role = role;
        this.mail = mail;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public int getRole() {
        return role;
    }

    public String getMail() {
        return mail;
    }

    public String getPass() {
        return pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public User сhangeId(int id) {
        return new User(id, role, mail, pass, firstName, lastName);
    }

    public User сhangeType(int type) {
        return new User(id, type, mail, pass, firstName, lastName);
    }

    public User сhangeMail(String mail) {
        return new User(id, role, mail, pass, firstName, lastName);
    }

    public User сhangePass(String pass) {
        return new User(id, role, mail, pass, firstName, lastName);
    }

    public User сhangeFirstName(String firstName) {
        return new User(id, role, mail, pass, firstName, lastName);
    }

    public User сhangeLastName(String lastName) {
        return new User(id, role, mail, pass, firstName, lastName);
    }
}
