package ru.innopolis.stc.pojo;

public class User {
    public static final int GUEST = 1;
    public static final int STUDENT = 2;
    public static final int TEACHER = 3;
    public static final int ADMINISTRATOR = 4;

    private int id;
    private int type;
    private String mail;
    private String pass;
    private String first_name;
    private String last_name;
    private String patronymic;

    public User(int id, int type, String mail, String pass, String first_name, String last_name, String patronymic) {
        this.id = id;
        this.type = type;
        this.mail = mail;
        this.pass = pass;
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getMail() {
        return mail;
    }

    public String getPass() {
        return pass;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public User сhangeId(int id) {
        return new User(id, type, mail, pass, first_name, last_name, patronymic);
    }

    public User сhangeType(int type) {
        return new User(id, type, mail, pass, first_name, last_name, patronymic);
    }

    public User сhangeMail(String mail) {
        return new User(id, type, mail, pass, first_name, last_name, patronymic);
    }

    public User сhangePass(String pass) {
        return new User(id, type, mail, pass, first_name, last_name, patronymic);
    }

    public User сhangeFirst_name(String first_name) {
        return new User(id, type, mail, pass, first_name, last_name, patronymic);
    }

    public User сhangeLast_name(String last_name) {
        return new User(id, type, mail, pass, first_name, last_name, patronymic);
    }

    public User сhangePatronymic(String patronymic) {
        return new User(id, type, mail, pass, first_name, last_name, patronymic);
    }
}
