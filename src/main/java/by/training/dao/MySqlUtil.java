package by.training.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlUtil {
    private static MySqlUtil instance = new MySqlUtil();

    private SessionFactory sessionFactory = null;

    private MySqlUtil() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("sessionFactory==null " + (sessionFactory ==null));
    }

    public static MySqlUtil getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return sessionFactory.getSessionFactoryOptions().getServiceRegistry().
                getService(ConnectionProvider.class).getConnection();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void close() {
        sessionFactory.close();
    }
}
