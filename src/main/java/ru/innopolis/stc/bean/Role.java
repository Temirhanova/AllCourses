package ru.innopolis.stc.bean;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    LEARNER,
    TEACHER,
    ADMINISTRATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
