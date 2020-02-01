package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.TicketEventDAOImpl;
import iot.lviv.ua.model.TicketEventEntity;

import java.sql.SQLException;
import java.util.List;

public class TicketEventService {
    public List<TicketEventEntity> findAll() throws SQLException {
        return new TicketEventDAOImpl().findAll();
    }

    public TicketEventEntity findById(Integer id) throws SQLException {
        return new TicketEventDAOImpl().findById(id);
    }

    public int create(TicketEventEntity entity) throws SQLException {
        return new TicketEventDAOImpl().create(entity);
    }

    public int update(TicketEventEntity entity) throws SQLException {
        return new TicketEventDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new TicketEventDAOImpl().delete(id);
    }
}
