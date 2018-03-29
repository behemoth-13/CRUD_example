package by.training.dao;

import by.training.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MODEL = "model";
    private static final String COLUMN_MAX_SPEED = "max_speed";
    private static final String COLUMN_CONSUMPTION = "consumption";
    private static final String COLUMN_VOLUME_TANK = "volume_tank";

    private static CarDao instance = new CarDao();
    private MySqlUtil util = MySqlUtil.getInstance();

    private CarDao(){}

    public static CarDao getInstance() {
        return instance;
    }

    public void addCar(Car car) throws SQLException {
        Connection connection = util.getConnection();
        String query = SqlQueries.SQL_ADD_CAR;
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, car.getModel());
        ps.setInt(2, car.getMaxSpeed());
        ps.setFloat(3, car.getConsumptionPer100Km());
        ps.setInt(4, car.getVolTank());
        ps.execute();

        connection.close();
    }

    public List<Car> getCars() throws SQLException, InterruptedException {
        List<Car> list = new ArrayList<>();
        Connection connection = util.getConnection();
        String query = SqlQueries.SQL_GET_CARS;
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet set = ps.executeQuery();

        while (set.next()) {
            Car car = new Car();

            car.setId(set.getInt(COLUMN_ID));
            car.setModel(set.getString(COLUMN_MODEL));
            car.setMaxSpeed(set.getInt(COLUMN_MAX_SPEED));
            car.setConsumptionPer100Km(set.getFloat(COLUMN_CONSUMPTION));
            car.setVolTank(set.getInt(COLUMN_VOLUME_TANK));

            list.add(car);
        }
        connection.close();
        return list;
    }

    public void deleteCar(int id) {

    }
}
