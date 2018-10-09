package ru.innopolis.stc.dao;

public interface BaseDao {
    void createTable();

    void deleteTable();

    boolean isTableCreated();
}
