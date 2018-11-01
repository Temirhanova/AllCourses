package ru.innopolis.stc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.bean.Lesson;
import ru.innopolis.stc.bean.User;
import ru.innopolis.stc.repository.CourseRepository;
import ru.innopolis.stc.repository.LessonRepository;
import ru.innopolis.stc.service.ICourseService;
import ru.innopolis.stc.service.ILessonService;

import java.util.List;

@Service
public class ILessonServiceImpl implements ILessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> findAll() {
        List<Lesson> lessons = (List<Lesson>) lessonRepository.findAll();
        return lessons;
    }

    @Override
    public List<Lesson> findAllByCourse(Course course) {
        List<Lesson> lessons = (List<Lesson>) lessonRepository.findAllByCourse(course);
        return lessons;
    }

    @Override
    public void add(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public Lesson getById(Integer lessonId) {
        return lessonRepository.findById(lessonId).get();
    }

    @Override
    public void update(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void delete(Lesson lesson) {
        lessonRepository.delete(lesson);
    }
}
