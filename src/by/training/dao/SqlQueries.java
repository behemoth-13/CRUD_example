package by.training.dao;

class SqlQueries {
    static final String SQL_ADD_CAR = "INSERT INTO car(model, max_speed, consumption, volume_tank) VALUES (?, ?, ?, ?)";
    static final String SQL_GET_CARS = "SELECT * FROM car ORDER BY model";
    static final String SQL_DEL_CAR_BY_ID = "DELETE FROM car WHERE id = ?";
    static final String SQL_GET_CAR_BY_ID = "SELECT * FROM car WHERE id = ?";
}