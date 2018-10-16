package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
}
