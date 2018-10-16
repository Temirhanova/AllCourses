package ru.innopolis.stc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc.bean.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
