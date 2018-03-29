package by.training.service;

import by.training.dao.CarDao;
import by.training.model.Car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CarService {
    private static CarService instance = new CarService();
    private Validator validator = Validator.getInstance();
    private CarDao dao = CarDao.getInstance();

    private CarService(){}

    public static CarService getInstance() {
        return instance;
    }

    public void addCar(HttpServletRequest request, HttpServletResponse response) {
        String model = request.getParameter("model").trim();
        String maxSpeed = request.getParameter("maxSpeed").trim();
        String consumption = request.getParameter("cons").trim();
        String volTank = request.getParameter("volTank").trim();
        String errors = validator.validate(model, maxSpeed, consumption, volTank);
        if (errors.isEmpty()) {
            Car car = new Car();
            car.setModel(model);
            car.setMaxSpeed(Integer.parseInt(maxSpeed));
            car.setConsumptionPer100Km(Float.parseFloat(consumption));
            car.setVolTank(Integer.parseInt(volTank));

            try {
                dao.addCar(car);
            } catch (SQLException e) {
                request.setAttribute("errors", "Please try again");
            }
        } else {
            request.setAttribute("errors", errors);
        }
    }

    public void getCars(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("cars", dao.getCars());
        } catch (SQLException | InterruptedException e) {
            request.setAttribute("errors", "Please try again");
        }
    }
}
