package ru.innopolis.stc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc.bean.Teacher;
import ru.innopolis.stc.bean.User;
import ru.innopolis.stc.repository.TeacherRepository;
import ru.innopolis.stc.service.ITeacherService;

import java.util.List;

@Service
public class ITeacherServiceImpl implements ITeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public Teacher findByUser(User user) {
        Teacher teacher = teacherRepository.findByUser(user);
        if (teacher == null) {
            teacher = new Teacher(0L, user, user.getMail() + " desctiption.", "photo");
            teacherRepository.save(teacher);
        }
        return teacher;
    }
}
