package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.Users;

import java.util.List;

public interface IUsersService {
    List<Users> findAll();
}
