package ru.innopolis.stc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc.bean.CourseUser;
import ru.innopolis.stc.repository.CourseUserRepository;
import ru.innopolis.stc.service.ICourseUserService;

import java.util.List;

@Service
public class ICourseUserServiceImpl implements ICourseUserService {
    @Autowired
    private CourseUserRepository courseUserRepository;

    @Override
    public List<CourseUser> findAll() {
        List<CourseUser> courseUsers = (List<CourseUser>) courseUserRepository.findAll();
        return courseUsers;
    }
}
