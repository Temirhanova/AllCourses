package ru.innopolis.stc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc.bean.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
