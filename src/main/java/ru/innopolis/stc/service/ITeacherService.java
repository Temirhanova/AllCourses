package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAll();
}
