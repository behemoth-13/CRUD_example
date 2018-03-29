package by.training.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlUtil {
    private static MySqlUtil instance = new MySqlUtil();

    private String url;
    private String login;
    private String password;

    private MySqlUtil() {}

    public void init(String url, String login, String password, String driverName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        this.url = url;
        this.login = login;
        this.password = password;
        Driver driver = (Driver) Class.forName(driverName).newInstance();
        DriverManager.registerDriver(driver);
        DriverManager.getConnection(url, login, password);
    }

    public static MySqlUtil getInstance() {
        return instance;
    }

    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }
}
