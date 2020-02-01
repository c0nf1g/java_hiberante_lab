package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.OrderEventDAOImpl;
import iot.lviv.ua.model.OrderEventEntity;

import java.sql.SQLException;
import java.util.List;

public class OrderEventService {
    public List<OrderEventEntity> findAll() throws SQLException {
        return new OrderEventDAOImpl().findAll();
    }

    public OrderEventEntity findById(Integer id) throws SQLException {
        return new OrderEventDAOImpl().findById(id);
    }

    public int create(OrderEventEntity entity) throws SQLException {
        return new OrderEventDAOImpl().create(entity);
    }

    public int update(OrderEventEntity entity) throws SQLException {
        return new OrderEventDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new OrderEventDAOImpl().delete(id);
    }
}
