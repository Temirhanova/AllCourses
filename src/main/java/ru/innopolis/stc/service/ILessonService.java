package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> findAll();
}
