package ru.innopolis.stc.dao;

import ru.innopolis.stc.pojo.User;

public interface UserDao extends BaseDao {
    User add(User user);

    User getById(int id);

    void update(User user);

    void delete(User user);
}