package ru.innopolis.stc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.repository.CourseRepository;
import ru.innopolis.stc.service.ICourseService;

import java.util.List;

@Service
public class ICourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        return courses;
    }

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getById(int courseId) {
        return courseRepository.findById(Long.valueOf(courseId)).get();
    }
}
