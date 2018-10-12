package ru.innopolis.stc.servisces;

import ru.innopolis.stc.dao.UserDao;
import ru.innopolis.stc.pojo.RegistrationInfo;
import ru.innopolis.stc.pojo.User;
import ru.innopolis.stc.servicesInterfaces.UserManager;

public class UserManagerImpl implements UserManager {
    private UserDao userDao;

    public UserManagerImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public RegistrationInfo registration(User user) {
        if (user.getFirstName() == null ||
                user.getSecondName() == null ||
                user.getMail() == null ||
                user.getPass() == null) {
            return new RegistrationInfo(user, RegistrationInfo.NOT_FILLED_FIELDS);
        }

        User existingUser = userDao.getByEmail(user.getMail());
        if (existingUser != null) {
            return new RegistrationInfo(user, RegistrationInfo.REPEATED_MILE);
        }
        return null;
    }
}
