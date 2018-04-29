package by.training.controller;

import by.training.dao.MySqlUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class Initializer implements ServletContextListener {

    private MySqlUtil util;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        util = MySqlUtil.getInstance();
        try {
            util.init("jdbcImpl:mysql://localhost:3306/crud_example?useSSL=false", "root", "root", "org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        util.close();
    }
}