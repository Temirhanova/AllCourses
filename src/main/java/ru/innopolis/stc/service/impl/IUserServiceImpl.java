package ru.innopolis.stc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc.bean.User;
import ru.innopolis.stc.repository.UserRepository;
import ru.innopolis.stc.service.IUserService;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }
}
