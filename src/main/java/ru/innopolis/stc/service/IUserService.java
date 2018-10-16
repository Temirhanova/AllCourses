package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
}
