package ru.innopolis.stc.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_user")
public class User {
/*
    public static final int GUEST = 1;
    public static final int STUDENT = 2;
    public static final int TEACHER = 3;
    public static final int ADMINISTRATOR = 4;

    public static final SystemUser getEmpty() {
        return new SystemUser(0, GUEST, "", "", "", "");
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private int role;

    @Column(name = "mail")
    private String mail;

    @Column(name = "pass")
    private String pass;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    public User() {
    }

    public User(int id, int role, String mail, String pass, String firstName, String secondName) {
        this.id = id;
        this.role = role;
        this.mail = mail;
        this.pass = pass;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                role == user.role &&
                Objects.equals(mail, user.mail) &&
                Objects.equals(pass, user.pass) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, mail, pass, firstName, secondName);
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "id=" + id +
                ", role=" + role +
                ", mail='" + mail + '\'' +
                ", pass='" + pass + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    /* public User сhangeId(int id) {
        return new User(id, role, mail, pass, firstName, secondName);
    }

    public User сhangeType(int type) {
        return new User(id, type, mail, pass, firstName, secondName);
    }

    public User сhangeMail(String mail) {
        return new User(id, role, mail, pass, firstName, secondName);
    }

    public User сhangePass(String pass) {
        return new User(id, role, mail, pass, firstName, secondName);
    }

    public User сhangeFirstName(String firstName) {
        return new User(id, role, mail, pass, firstName, secondName);
    }

    public User сhangeSecondName(String secondName) {
        return new User(id, role, mail, pass, firstName, secondName);
    }*/
}
