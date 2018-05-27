package by.training.dao;

import by.training.model.Car;

import java.util.List;

public interface CarDao {
    void save(Car car) throws DaoException;
    List<Car> getAll() throws DaoException;
    void delete(int id) throws DaoException;
    Car getById(int id) throws DaoException;
}