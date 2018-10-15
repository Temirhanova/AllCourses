package ru.innopolis.stc.services;

import ru.innopolis.stc.pojo.RegistrationInfo;
import ru.innopolis.stc.pojo.User;

public interface UserManager {
    RegistrationInfo registration(User user);
}
