package ru.innopolis.stc.bean;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int role;
    private String mail;
    private String pass;
    private String firstName;
    private String secondName;

    public Users() {
    }


    public Users(int id, int role, String mail, String pass, String firstName, String secondName) {
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
        Users users = (Users) o;
        return id == users.id &&
                role == users.role &&
                Objects.equals(mail, users.mail) &&
                Objects.equals(pass, users.pass) &&
                Objects.equals(firstName, users.firstName) &&
                Objects.equals(secondName, users.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, mail, pass, firstName, secondName);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", role=" + role +
                ", mail='" + mail + '\'' +
                ", pass='" + pass + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
