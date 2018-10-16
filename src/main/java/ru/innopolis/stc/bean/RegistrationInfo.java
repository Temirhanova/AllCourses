package ru.innopolis.stc.bean;

public class RegistrationInfo {
    public static final int NON = 0;
    public static final int REPEATED_MILE = 1;
    public static final int NOT_FILLED_FIELDS = 2;
    public static final int SUCCESSFUL_REGISTRATION = 3;

    private User user;
    private int info;

    public RegistrationInfo(User user, int info) {
        this.user = user;
        this.info = info;
    }

    public User getUser() {
        return user;
    }

    public int getInfo() {
        return info;
    }
}
