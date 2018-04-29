package by.training.dao;

public class SqlQueries {
    public static final String SQL_ADD_CAR = "INSERT INTO car(model, max_speed, consumption, volume_tank) VALUES (?, ?, ?, ?)";
    public static final String SQL_GET_CARS = "SELECT * FROM car ORDER BY model";
    public static final String SQL_DEL_CAR_BY_ID = "DELETE FROM car WHERE id = ?";
    public static final String SQL_GET_CAR_BY_ID = "SELECT * FROM car WHERE id = ?";
}