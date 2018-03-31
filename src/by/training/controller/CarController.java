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
        String page;
        if (car != null) {
            try {
                service.addCar(car);
                page = "/pages/list.jsp";
            } catch (ServiceException e) {
                request.setAttribute("errors", "Please try again");
                page = "/pages/list.jsp";
            }
        } else {
            page = "/pages/list.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String page = "/pages/index.jsp";
        switch (request.getParameter("act")) {
            case "list" : {
                try {
                    List<Car> cars = service.getCars();
                    request.setAttribute("cars", cars);
                } catch (ServiceException e) {
                    request.setAttribute("errors", "Please try again");
                }
                page = "/pages/list.jsp";
                break;
            }
            case "del" : {
                try {
                    int id = validator.getValidId(request);
                    if (id > 0) {
                        service.deleteCar(id);
                    } else {
                        request.setAttribute("errors", "Wrong data");
                    }
                } catch (ServiceException e) {
                    request.setAttribute("errors", "Please try again");
                }
                page = "/pages/list.jsp";
                break;
            }
            case "edit" : {
                try {
                    int id = validator.getValidId(request);
                    if (id > 0) {
                        Car car = service.getCarById(id);
                        request.setAttribute("car", car);
                        page = "/pages/car.jsp";
                    } else {
                        request.setAttribute("errors", "Wrong data");
                        page = "/pages/list.jsp";
                    }
                } catch (ServiceException e) {
                    page = "/pages/list.jsp";
                    request.setAttribute("errors", "Please try again");
                }
                break;
            }
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }


}
