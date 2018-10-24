package ru.innopolis.stc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc.bean.Course;
import ru.innopolis.stc.bean.Lesson;

import java.util.List;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {
    List<Lesson> findAllByCourse(Course course);
}
