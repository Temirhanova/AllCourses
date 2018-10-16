package ru.innopolis.stc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc.bean.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
}
