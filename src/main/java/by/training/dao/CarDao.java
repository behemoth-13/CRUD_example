package by.training.dao;

import by.training.model.Car;

import java.util.List;

public interface CarDao {
    void addCar(Car car) throws DaoException;
    List<Car> getCars() throws DaoException;
    void deleteCar(int id) throws DaoException;
    Car getCarById(int id) throws DaoException;
}