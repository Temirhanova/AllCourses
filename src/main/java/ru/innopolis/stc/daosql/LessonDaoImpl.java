package ru.innopolis.stc.daosql;

import org.apache.log4j.Logger;
import ru.innopolis.stc.dao.LessonDao;
import ru.innopolis.stc.db.connectionPool.DatabaseConnectionPool;
import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements LessonDao {
    private final static Logger LOGGER = Logger.getLogger(LessonDaoImpl.class);
    private DatabaseConnectionPool connectionPool;

    public LessonDaoImpl(DatabaseConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public boolean addLesson(Lesson lesson) {
        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO \"lesson\" values (DEFAULT, ?, ?, ?, ?) RETURNING id");
            preparedStatement.setInt(1, (lesson.getCourse()).getId());
            preparedStatement.setString(2, lesson.getName());
            preparedStatement.setString(3, lesson.getContent());
            preparedStatement.setString(4, lesson.getHomework());
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e);
            return false;
        }
        return true;
    }

    @Override
    public Lesson getLessonById(Integer id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM \"lesson\" WHERE id = ?");) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    return new Lesson(
                            resultSet.getInt(1),
                            new Course(1, false, "a", "a"),
                            // TODO: use method Course.getCourseById(resultSet.getInt(2)) from CourseDaoImpl,
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Lesson> getLessonList(Integer id) {
        List<Lesson> result = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM \"lesson\" WHERE id = ?");) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(new Lesson(
                            resultSet.getInt(1),
                            new Course(1, false, "a", "a"),
                            // TODO: use method Course.getCourseById(resultSet.getInt(2)) from CourseDaoImpl
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateLessonById(Lesson lesson) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE \"lesson\" SET course_id=?, name=?, content=?, home_work=? " +
                             "WHERE id=?");) {
            preparedStatement.setInt(1, (lesson.getCourse()).getId());
            preparedStatement.setString(2, lesson.getName());
            preparedStatement.setString(3, lesson.getContent());
            preparedStatement.setString(4, lesson.getHomework());
            preparedStatement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteLessonById(Integer id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM \"lesson\" WHERE id=?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
