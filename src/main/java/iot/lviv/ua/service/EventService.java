package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.EventDAOImpl;
import iot.lviv.ua.model.EventEntity;

import java.sql.SQLException;
import java.util.List;

public class EventService {
    public List<EventEntity> findAll() throws SQLException {
        return new EventDAOImpl().findAll();
    }

    public EventEntity findById(Integer id) throws SQLException {
        return new EventDAOImpl().findById(id);
    }

    public int create(EventEntity entity) throws SQLException {
        return new EventDAOImpl().create(entity);
    }

    public int update(EventEntity entity) throws SQLException {
        return new EventDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new EventDAOImpl().delete(id);
    }
}
