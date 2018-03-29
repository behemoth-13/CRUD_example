package by.training.controller;

import by.training.dao.MySqlUtil;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.SQLException;

public class Listener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        MySqlUtil util = MySqlUtil.getInstance();
        try {
            util.init("jdbc:mysql://localhost:3306/crud_example?useSSL=false", "root", "root", "org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
    }
}
