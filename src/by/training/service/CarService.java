package by.training.service;

import by.training.dao.CarDao;
import by.training.model.Car;

import java.sql.SQLException;
import java.util.List;

public class CarService {
    private static CarService instance = new CarService();
    private CarDao dao = CarDao.getInstance();

    private CarService(){}

    public static CarService getInstance() {
        return instance;
    }

    public void addCar(Car car) throws ServiceException{
        try {
            dao.addCar(car);
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Car> getCars() throws ServiceException {
        try {
            return dao.getCars();
        } catch (SQLException | InterruptedException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void deleteCar(int id) throws ServiceException {
        try {
            dao.deleteCar(id);
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Car getCarById(int id) throws ServiceException {
        try {
            return dao.getCarById(id);
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
