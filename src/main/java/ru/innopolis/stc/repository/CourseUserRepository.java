package ru.innopolis.stc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc.bean.CourseUser;

@Repository
public interface CourseUserRepository extends CrudRepository<CourseUser, Long> {
}
