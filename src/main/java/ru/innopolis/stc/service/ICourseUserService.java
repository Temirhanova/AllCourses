package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.CourseUser;

import java.util.List;

public interface ICourseUserService {
    List<CourseUser> findAll();
}
