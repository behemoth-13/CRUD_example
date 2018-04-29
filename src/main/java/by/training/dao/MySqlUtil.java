package by.training.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlUtil {
    private static MySqlUtil instance = new MySqlUtil();

    private static SessionFactory sessionFactory = null;

    private String url;
    private String login;
    private String password;

    private MySqlUtil() {}

    public void init(String url, String login, String password, String driverName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        this.url = url;
        this.login = login;
        this.password = password;
        sessionFactory = new Configuration().configure().buildSessionFactory();
//        Driver driver = (Driver) Class.forName(driverName).newInstance();
//        DriverManager.registerDriver(driver);
//        DriverManager.getConnection(url, login, password);
    }

    public static MySqlUtil getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void close() {
        sessionFactory.close();
    }
}
