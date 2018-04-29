package by.training.dao.jdbcImpl;

import by.training.dao.CarDao;
import by.training.dao.DaoException;
import by.training.dao.MySqlUtil;
import by.training.dao.SqlQueries;
import by.training.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoJdbc implements CarDao{
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MODEL = "model";
    private static final String COLUMN_MAX_SPEED = "max_speed";
    private static final String COLUMN_CONSUMPTION = "consumption";
    private static final String COLUMN_VOLUME_TANK = "volume_tank";

    private static CarDaoJdbc instance = new CarDaoJdbc();
    private MySqlUtil util = MySqlUtil.getInstance();

    private CarDaoJdbc(){}

    public static CarDaoJdbc getInstance() {
        return instance;
    }

    @Override
    public void addCar(Car car) throws DaoException {
        try {
            Connection connection = util.getConnection();
            String query = SqlQueries.SQL_ADD_CAR;
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, car.getModel());
            ps.setInt(2, car.getMaxSpeed());
            ps.setFloat(3, car.getConsumptionPer100Km());
            ps.setInt(4, car.getVolTank());
            ps.execute();

            connection.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Car> getCars() throws DaoException {
        try {
            List<Car> list = new ArrayList<>();
            Connection connection = util.getConnection();
            String query = SqlQueries.SQL_GET_CARS;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet set = ps.executeQuery();

            while (set.next()) {
                Car car = new Car();
                fillCar(car, set);
                list.add(car);
            }
            connection.close();
            return list;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void deleteCar(int id) throws DaoException {
        try {
            Connection connection = util.getConnection();
            String query = SqlQueries.SQL_DEL_CAR_BY_ID;
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, id);
            ps.execute();

            connection.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public Car getCarById(int id) throws DaoException {
        try {
            Car car = null;
            Connection connection = util.getConnection();
            String query = SqlQueries.SQL_GET_CAR_BY_ID;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();

            if (set.next()) {
                car = new Car();
                fillCar(car, set);
            }
            connection.close();
            return car;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private void fillCar(Car car, ResultSet set) throws SQLException {
        car.setId(set.getInt(COLUMN_ID));
        car.setModel(set.getString(COLUMN_MODEL));
        car.setMaxSpeed(set.getInt(COLUMN_MAX_SPEED));
        car.setConsumptionPer100Km(set.getFloat(COLUMN_CONSUMPTION));
        car.setVolTank(set.getInt(COLUMN_VOLUME_TANK));
    }
}
