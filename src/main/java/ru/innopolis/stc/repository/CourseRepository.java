package ru.innopolis.stc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.bean.Lesson;
import ru.innopolis.stc.bean.User;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findAllByModerationstatus(Boolean moderationstatus);
    List<Course> findAllByTeacher(User teacher);
}
