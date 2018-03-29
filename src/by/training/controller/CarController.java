package by.training.controller;

import by.training.model.Car;
import by.training.service.CarService;
import by.training.service.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarController extends HttpServlet{

    private CarService service = CarService.getInstance();
    private CarValidator validator = CarValidator.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Car car = validator.getValidCar(request);
        if (car != null) {
            try {
                service.addCar(car);
            } catch (ServiceException e) {
                request.setAttribute("errors", "Please try again");
            }
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        switch (request.getParameter("act")) {
            case "list" : {
                try {
                    List<Car> cars = service.getCars();
                    request.setAttribute("cars", cars);
                } catch (ServiceException e) {
                    request.setAttribute("errors", "Please try again");
                }
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/list.jsp");
                dispatcher.forward(request, response);
            }
            case "del" : {
                try {
                    int id = validator.getValidId(request);
                    if (id > 0) {
                        service.deleteCar(id);
                    }
                } catch (ServiceException e) {
                    request.setAttribute("errors", "Please try again");
                }
            }
        }
    }


}
