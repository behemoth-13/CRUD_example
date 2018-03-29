package by.training.dao;

class SqlQueries {
    static final String SQL_ADD_CAR = "INSERT INTO car(model, max_speed, consumption, volume_tank) VALUES (?, ?, ?, ?)";
    static final String SQL_GET_CARS = "SELECT * FROM car ORDER BY model";
}