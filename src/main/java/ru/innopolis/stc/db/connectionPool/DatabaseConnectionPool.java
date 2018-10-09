package ru.innopolis.stc.db.connectionPool;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionPool {
    private final static Logger LOGGER = Logger.getLogger(DatabaseConnectionPool.class);
    private String url;
    private String user;
    private String pass;

    public DatabaseConnectionPool(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            //TODO нужно будет сделать реализацию с пулом
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
            throw e;
        } catch (SQLException e) {
            LOGGER.error(e);
            throw e;
        }
    }
}
