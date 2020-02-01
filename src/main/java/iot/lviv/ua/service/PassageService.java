package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.PassageDAOImpl;
import iot.lviv.ua.model.PassageEntity;

import java.sql.SQLException;
import java.util.List;

public class PassageService {
    public List<PassageEntity> findAll() throws SQLException {
        return new PassageDAOImpl().findAll();
    }

    public PassageEntity findById(Integer id) throws SQLException {
        return new PassageDAOImpl().findById(id);
    }

    public int create(PassageEntity entity) throws SQLException {
        return new PassageDAOImpl().create(entity);
    }

    public int update(PassageEntity entity) throws SQLException {
        return new PassageDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new PassageDAOImpl().delete(id);
    }
}
