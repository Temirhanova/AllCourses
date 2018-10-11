package ru.innopolis.stc.services;

import ru.innopolis.stc.dao.CourseDao;
import ru.innopolis.stc.daosql.CourseDaoImpl;
import ru.innopolis.stc.db.connectionPool.DatabaseConnectionPool;
import ru.innopolis.stc.pojo.Course;
import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    public CourseServiceImpl() {
        DatabaseConnectionPool databaseConnectionPool = new DatabaseConnectionPool("jdbc:postgresql://localhost:5432/allcourse", "postgres", "1234");
        courseDao = new CourseDaoImpl(databaseConnectionPool);
    }

    @Override
    public Course add(Course course) {
        return courseDao.add(course);
    }

    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }
}