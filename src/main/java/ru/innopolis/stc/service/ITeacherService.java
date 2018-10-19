package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.Teacher;
import ru.innopolis.stc.bean.User;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAll();

    Teacher findByUser(User user);
}
