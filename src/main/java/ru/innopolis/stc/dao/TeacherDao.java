package ru.innopolis.stc.dao;

import ru.innopolis.stc.pojo.Teacher;

public interface TeacherDao {
    Teacher add(Teacher teacher);
    Teacher getById(Integer id);
    Boolean update(Teacher teacher);
}
