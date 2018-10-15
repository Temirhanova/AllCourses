package ru.innopolis.stc.daosql;

import org.apache.log4j.Logger;
import ru.innopolis.stc.dao.TeacherDao;
import ru.innopolis.stc.db.connectionPool.DatabaseConnectionPool;
import ru.innopolis.stc.pojo.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImpl implements TeacherDao {
    private final static Logger LOGGER = Logger.getLogger(TeacherDaoImpl.class);
    private DatabaseConnectionPool connectionPool;

    public TeacherDaoImpl(DatabaseConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Teacher add(Teacher teacher) {
        try (Connection connection = connectionPool.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO \"teacher\" VALUES (DEFAUL, ?,?,?) RETURNING id");
            preparedStatement.setInt(1, teacher.getUser().getId());
            preparedStatement.setString(2, teacher.getDescription());
            preparedStatement.setBytes(3, teacher.getPhoto());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return getById(resultSet.getInt(1));
                }
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Teacher getById(Integer id) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM teacher WHERE id=?");
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    UserDaoJDBC userDao = new UserDaoJDBC();
                    Teacher teacher = new Teacher(
                            resultSet.getInt(1),
                            userDao.getById(resultSet.getInt(2)),
                            resultSet.getString(3),
                            resultSet.getBytes(4));
                    return teacher;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Boolean update(Teacher teacher) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE teacher SET user_id=?, description=?, photo=? WHERE id=?");
            preparedStatement.setInt(1, teacher.getUser().getId());
            preparedStatement.setString(2, teacher.getDescription());
            preparedStatement.setBytes(3, teacher.getPhoto());
            preparedStatement.setInt(4, teacher.getId());
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e);
            return false;
        }
        return true;
    }
}
