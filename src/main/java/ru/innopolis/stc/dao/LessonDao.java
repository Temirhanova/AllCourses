package ru.innopolis.stc.dao;

import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.Lesson;

import java.util.List;

public interface LessonDao {
    Lesson addLesson(Lesson lesson);

    Lesson getLessonById(Integer id);

    List<Lesson> getLessonList(Course course);

    boolean updateLessonById(Lesson lesson);

    boolean deleteLessonById(Integer id);
}
