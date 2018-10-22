package ru.innopolis.stc.service;


import ru.innopolis.stc.bean.TestSequence;

import java.util.List;

public interface ITestService {
    List<TestSequence> findAll();
    void save(TestSequence testSequence);

    TestSequence getById(Long id);
}
