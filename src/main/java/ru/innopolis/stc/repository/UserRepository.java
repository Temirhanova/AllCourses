package ru.innopolis.stc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc.bean.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByMail(String mail);
}
