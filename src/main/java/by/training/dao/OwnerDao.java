package by.training.dao;

import by.training.model.Owner;

import java.util.List;

public interface OwnerDao {
    void save(Owner owner) throws DaoException;
    List<Owner> getAll() throws DaoException;
    void delete(int id) throws DaoException;
    Owner getById(int id) throws DaoException;
    void saveOrUpdate(Owner owner) throws DaoException;
}
