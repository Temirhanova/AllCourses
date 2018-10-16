package ru.innopolis.stc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc.bean.Lesson;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {
}
