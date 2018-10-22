package ru.innopolis.stc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc.bean.TestSequence;
import ru.innopolis.stc.bean.User;

@Repository
public interface TestRepository extends CrudRepository<TestSequence, Long> {
}
