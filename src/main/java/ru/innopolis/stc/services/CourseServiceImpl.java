package ru.innopolis.stc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc.dao.CourseDao;
import ru.innopolis.stc.daosql.CourseDaoImpl;
import ru.innopolis.stc.db.connectionPool.DatabaseConnectionPool;
import ru.innopolis.stc.pojo.Course;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl() {
        courseDao = new CourseDaoImpl(new DatabaseConnectionPool());
    }

    @Override
    public Course add(Course course) {
        return courseDao.add(course);
    }

    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }

    @Override
    public Course getById(int courseId) {
        return courseDao.getById(courseId);
    }
}