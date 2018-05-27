package by.training.dao.hiberImpl;

import by.training.dao.DaoException;
import by.training.dao.MySqlUtil;
import by.training.dao.OwnerDao;
import by.training.model.Owner;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OwnerDaoHibern implements OwnerDao{
    private static OwnerDaoHibern instance = new OwnerDaoHibern();
    private MySqlUtil util = MySqlUtil.getInstance();

    private OwnerDaoHibern(){}

    public static OwnerDaoHibern getInstance() {
        return instance;
    }

    @Override
    public void save(Owner owner) throws DaoException {
        Session session = util.getSession();
        session.beginTransaction();
        session.save(owner);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Owner> getAll() throws DaoException {
        Session session = util.getSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Owner> query = builder.createQuery(Owner.class);
        Root<Owner> root = query.from(Owner.class);
        query.select(root);
        Query<Owner> q = session.createQuery(query);
        List<Owner> owners = q.getResultList();
        session.getTransaction().commit();
        session.close();
        return owners;
    }

    @Override
    public void delete(int id) throws DaoException {
        Session session = util.getSession();
        session.beginTransaction();
        Owner owner = new Owner();
        owner.setId(id);
        session.delete(owner);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Owner getById(int id) throws DaoException {
        Session session = util.getSession();
        session.beginTransaction();
        Owner owner = session.get(Owner.class, id);
        session.getTransaction().commit();
        session.close();
        return owner;
    }

    @Override
    public void saveOrUpdate(Owner owner) throws DaoException {
        Session session = util.getSession();
        session.beginTransaction();
        session.saveOrUpdate(owner);
        session.getTransaction().commit();
        session.close();
    }
}
