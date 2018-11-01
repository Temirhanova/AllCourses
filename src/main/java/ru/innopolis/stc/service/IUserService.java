package ru.innopolis.stc.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.innopolis.stc.bean.User;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<User> findAll();
    User getById(Long id);
    User findByMail(String mail);
    void addUser(User user);
    void save(User user);
    void update(User user);
}
