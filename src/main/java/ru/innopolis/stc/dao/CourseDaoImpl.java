package ru.innopolis.stc.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc.db.connectionPool.DatabaseConnectionPool;
import ru.innopolis.stc.pojo.Course;
import ru.innopolis.stc.pojo.Teacher;
import ru.innopolis.stc.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private final static Logger LOGGER = Logger.getLogger(CourseDaoImpl.class);


    private DatabaseConnectionPool connectionPool;

    public CourseDaoImpl(DatabaseConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Course add(Course course) {
        String query = "INSERT INTO course values (DEFAULT, ?, ?, ?, ?) RETURNING id";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, course.isModerationStatus());
            preparedStatement.setString(2, course.getName());
            preparedStatement.setString(3, course.getDescription());
            preparedStatement.setInt(4, course.getTeacher().getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                course.changeId(resultSet.getInt(1));
            }
            resultSet.close();
            return course;
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Course update(Course course) {
        String query = "UPDATE course " +
                "SET moderation_status = ?, name = ?, description = ? " +
                "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, course.isModerationStatus());
            preparedStatement.setString(2, course.getName());
            preparedStatement.setString(3, course.getDescription());
            preparedStatement.setInt(4, course.getTeacher().getId());
            preparedStatement.execute();
            return course;
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Course getById(int id) {
        Course course = null;
        String query = "SELECT * FROM course  " +
                "JOIN teacher ON course.teacher_id = teacher.id " +
                "WHERE id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                course = new Course();
                course.changeId(resultSet.getInt(1));
                course.changeModerationStatus(resultSet.getBoolean(2));
                course.changeName(resultSet.getString(3));
                course.changeDescription(resultSet.getString(4));

                Teacher teacher = new Teacher();
                teacher.changeId(resultSet.getInt(5));
                teacher.changeUser(new User().сhangeId(resultSet.getInt(6)));
                teacher.changeDescription(resultSet.getString(7));
                course.changeTeacher(teacher);
            }
            resultSet.close();
        } catch (SQLException  | ClassNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Course delete(Course course) {
        String query = "DELETE FROM course WHERE id=?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setLong(1, course.getId());
            preparedStatement.execute();
            return course;
        } catch (SQLException  | ClassNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        String query = "SELECT * FROM course  " +
                "JOIN teacher ON course.teacher_id = teacher.id";
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query))
        {
            List<Course> courseList = new ArrayList<>();
            while (resultSet.next()) {
                Course course = new Course();
                course.changeId(resultSet.getInt(1));
                course.changeModerationStatus(resultSet.getBoolean(2));
                course.changeName(resultSet.getString(3));
                course.changeDescription(resultSet.getString(4));

                Teacher teacher = new Teacher();
                teacher.changeId(resultSet.getInt(5));
                teacher.changeUser(new User().сhangeId(resultSet.getInt(6)));
                teacher.changeDescription(resultSet.getString(7));
                course.changeTeacher(teacher);
                courseList.add(course);
            }
            return courseList;
        } catch (SQLException  | ClassNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

}
