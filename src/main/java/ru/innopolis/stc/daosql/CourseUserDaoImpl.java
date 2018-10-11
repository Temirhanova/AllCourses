package ru.innopolis.stc.daosql;

import org.apache.log4j.Logger;
import ru.innopolis.stc.controller.StartPage;
import ru.innopolis.stc.dao.CourseUserDao;
import ru.innopolis.stc.db.connectionPool.DatabaseConnectionPool;
import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseUserDaoImpl implements CourseUserDao {
    DatabaseConnectionPool databaseConnectionPool = new DatabaseConnectionPool("jdbc:postgresql://localhost:5432/allcourse", "postgres", "1234");
    private final static Logger LOGGER = Logger.getLogger(StartPage.class);
    @Override
    public List<User> findUsers(User user) {
        List<User> users = null;
        try (Connection connection = databaseConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select u.id, u.role, u.email, u.password, u.firstname, u.secondname from course_user as cu inner join \"user\" as u on cu.user_id = u.id and cu.user_id = ?");
            preparedStatement.setInt(1, user.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                users = new ArrayList<>();
                while (resultSet.next()) {
                    users.add(new User(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return users;
    }

    @Override
    public List<Course> findCourses(Course course) {
        List<Course> courses = null;
        try (Connection connection = databaseConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select c.id, c.modetationstatus, c.name, c.description, c.teacher_id from course_user as cu inner join course as c on cu.course_id = c.id and cu.course_id = ?");
            preparedStatement.setInt(1, course.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                courses = new ArrayList<>();
                while (resultSet.next()) {
                    courses.add(new Course(
                            resultSet.getInt(1),
                            resultSet.getBoolean(2),
                            resultSet.getString(3),
                            resultSet.getString(4)));
                    // TODO: 10.10.2018 use method CourseDao.getID(int id); with check. Source from resultSet.getInt(5)
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return courses;
    }
}
