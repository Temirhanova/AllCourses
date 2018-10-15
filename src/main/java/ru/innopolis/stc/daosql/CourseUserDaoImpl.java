package ru.innopolis.stc.daosql;

import org.apache.log4j.Logger;
import ru.innopolis.stc.dao.CourseUserDao;
import ru.innopolis.stc.db.connectionPool.DatabaseConnectionPool;
import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.CourseUser;
import ru.innopolis.stc.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseUserDaoImpl implements CourseUserDao {
    DatabaseConnectionPool databaseConnectionPool = new DatabaseConnectionPool();
    private final static Logger LOGGER = Logger.getLogger(CourseUserDaoImpl.class);
    @Override
    public List<CourseUser> findUsers(Course course) {
        List<CourseUser> courseUsers = null;
        try (Connection connection = databaseConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select cu.course_id, cu.user_id from course_user as cu inner join course as c on cu.course_id = c.id and cu.course_id = ?");
            preparedStatement.setInt(1, course.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                courseUsers = new ArrayList<>();
                while (resultSet.next()) {
                    courseUsers.add(new CourseUser(null, null));
//                            resultSet.getInt(1),
//                            resultSet.getInt(2));
                    // TODO: 10.10.2018 use method CourseDao.getID(int id); with check. use method UserDao.getID(int id); with check.
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return courseUsers;
    }

    @Override
    public List<CourseUser> findCourses(User user) {
        List<CourseUser> courseUsers = null;
        try (Connection connection = databaseConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select cu.course_id, cu.user_id from course_user as cu inner join \"user\" as u on cu.user_id = u.id and cu.user_id = ?");
            preparedStatement.setInt(1, user.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                courseUsers = new ArrayList<>();
                while (resultSet.next()) {
                    courseUsers.add(new CourseUser(
                            null, null) // TODO: 11.10.2018 this add getId() from courseDao and add getId() from userDao
                    );
                    // TODO: 11.10.2018 this add getId() from courseDao and add getId() from userDao
//                            resultSet.getInt(1),
//                            resultSet.getInt(2)));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return courseUsers;
    }
}
