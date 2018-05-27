package by.training.dao.hiberImpl;

import by.training.dao.CarDao;
import by.training.dao.MySqlUtil;
import by.training.model.Car;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CarDaoHibern implements CarDao{
    private static CarDaoHibern instance = new CarDaoHibern();
    private MySqlUtil util = MySqlUtil.getInstance();

    private CarDaoHibern(){}

    public static CarDaoHibern getInstance() {
        return instance;
    }

    @Override
    public void save(Car car) {
        Session session = util.getSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Car> getAll() {
        Session session = util.getSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Car> query = builder.createQuery(Car.class);
        Root<Car> root = query.from(Car.class);
        query.select(root);
        Query<Car> q = session.createQuery(query);
        List<Car> cars = q.getResultList();
        session.getTransaction().commit();
        session.close();
        return cars;
    }

    @Override
    public void delete(int id) {
        Session session = util.getSession();
        session.beginTransaction();
        Car car = new Car();
        car.setId(id);
        session.delete(car);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Car getById(int id) {
        Session session = util.getSession();
        session.beginTransaction();
        Car car = session.get(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return car;
    }
}
