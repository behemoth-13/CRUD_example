package by.training.controller;

import by.training.dao.MySqlUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Destroyer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        MySqlUtil.getInstance().close();
    }
}