package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.bean.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> findAll();
    List<Lesson> findAllByCourse(Course course);
    void add(Lesson lesson);
    Lesson getById(Integer lessonId);
    void update(Lesson lesson);
    void delete(Lesson lesson);
}
