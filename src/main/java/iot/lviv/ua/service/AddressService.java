package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.AddressDAOImpl;
import iot.lviv.ua.model.AddressEntity;

import java.sql.SQLException;
import java.util.List;

public class AddressService {
    public List<AddressEntity> findAll() throws SQLException {
        return new AddressDAOImpl().findAll();
    }

    public AddressEntity findById(Integer id) throws SQLException {
        return new AddressDAOImpl().findById(id);
    }

    public int create(AddressEntity entity) throws SQLException {
        return new AddressDAOImpl().create(entity);
    }

    public int update(AddressEntity entity) throws SQLException {
        return new AddressDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new AddressDAOImpl().delete(id);
    }
}
