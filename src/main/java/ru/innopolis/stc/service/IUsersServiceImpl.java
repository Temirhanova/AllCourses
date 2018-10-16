package ru.innopolis.stc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc.bean.Users;
import ru.innopolis.stc.repository.UsersRepository;

import java.util.List;

@Service
public class IUsersServiceImpl implements IUsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        List<Users> usersList = (List<Users>) usersRepository.findAll();
        return usersList;
    }
}
