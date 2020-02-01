package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.OrderPassageDAOImpl;
import iot.lviv.ua.model.OrderPassageEntity;

import java.sql.SQLException;
import java.util.List;

public class OrderPassageService {
    public List<OrderPassageEntity> findAll() throws SQLException {
        return new OrderPassageDAOImpl().findAll();
    }

    public OrderPassageEntity findById(Integer id) throws SQLException {
        return new OrderPassageDAOImpl().findById(id);
    }

    public int create(OrderPassageEntity entity) throws SQLException {
        return new OrderPassageDAOImpl().create(entity);
    }

    public int update(OrderPassageEntity entity) throws SQLException {
        return new OrderPassageDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new OrderPassageDAOImpl().delete(id);
    }
}
