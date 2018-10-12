package ru.innopolis.stc.daosql;

import org.apache.log4j.Logger;
import ru.innopolis.stc.dao.UserDao;
import ru.innopolis.stc.db.connectionPool.DatabaseConnectionPool;
import ru.innopolis.stc.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoJDBC implements UserDao {
    private final static Logger LOGGER = Logger.getLogger(UserDaoJDBC.class);
    private DatabaseConnectionPool connectionPool;

    public UserDaoJDBC(DatabaseConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public User add(User user) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO \"user\" values (DEFAULT, ?, ?, ?, ?, ?) RETURNING id");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setInt(4, user.getRole());
            preparedStatement.setString(5, user.getPass());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return getById(resultSet.getInt(1));
                }
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public User getById(int id) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM \"user\" WHERE id = ?");
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User(
                            resultSet.getInt(1),
                            resultSet.getInt(5),
                            resultSet.getString(4),
                            resultSet.getString(6),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    );
                    return user;
                }
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public User getByEmail(String email) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM \"user\" WHERE email = ?");
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User(
                            resultSet.getInt(1),
                            resultSet.getInt(5),
                            resultSet.getString(4),
                            resultSet.getString(6),
                            resultSet.getString(2),
                            resultSet.getString(3)
                    );
                    return user;
                }
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void update(User user) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE \"user\" SET firstname=?, secondname=?, email=?, role=?, password=? WHERE id=?");
            preparedStatement.setInt(6, user.getId());
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setInt(4, user.getRole());
            preparedStatement.setString(5, user.getPass());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(User user) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM \"user\" WHERE id=? AND firstname=? AND secondname=? AND email=? AND role=? AND password=?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getSecondName());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.setInt(5, user.getRole());
            preparedStatement.setString(6, user.getPass());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
    }
}
