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
        if (user == null) {
            return new RegistrationInfo(User.getEmpty(), RegistrationInfo.NON);
        }
        if (user.getFirstName().length() < 2 ||
                user.getSecondName().length() < 2 ||
                user.getMail().length() < 3 ||
                user.getPass().length() < 3) {
            return new RegistrationInfo(user, RegistrationInfo.NOT_FILLED_FIELDS);
        }

        User existingUser = userDao.getByEmail(user.getMail());
        if (existingUser != null) {
            return new RegistrationInfo(user, RegistrationInfo.REPEATED_MILE);
        }

        user = userDao.add(user);
        return new RegistrationInfo(user, RegistrationInfo.SUCCESSFUL_REGISTRATION);
    }
}
