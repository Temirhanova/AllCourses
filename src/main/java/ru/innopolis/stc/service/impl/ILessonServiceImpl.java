package ru.innopolis.stc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc.bean.Lesson;
import ru.innopolis.stc.repository.LessonRepository;
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
}
