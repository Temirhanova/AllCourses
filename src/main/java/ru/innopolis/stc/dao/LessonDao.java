package ru.innopolis.stc.dao;

import ru.innopolis.stc.pojo.Lesson;

import java.util.List;

public interface LessonDao {
    boolean addLesson(Lesson lesson);

    Lesson getLessonById(Integer id);

    List<Lesson> getLessonList(Integer id);

    boolean updateLessonById(Lesson lesson);

    boolean deleteLessonById(Integer id);
}
