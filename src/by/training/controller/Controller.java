package by.training.controller;

import by.training.service.CarService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet{

    private CarService service = CarService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        service.addCar(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        switch (request.getParameter("act")) {
            case "list" : {
                service.getCars(request, response);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/list.jsp");
                dispatcher.forward(request, response);
            }
            case "del" : {
                //TODO
            }
        }
    }
}
