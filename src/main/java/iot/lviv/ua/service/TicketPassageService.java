package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.TicketPassageDAOImpl;
import iot.lviv.ua.model.TicketPassageEntity;

import java.sql.SQLException;
import java.util.List;

public class TicketPassageService {
    public List<TicketPassageEntity> findAll() throws SQLException {
        return new TicketPassageDAOImpl().findAll();
    }

    public TicketPassageEntity findById(Integer id) throws SQLException {
        return new TicketPassageDAOImpl().findById(id);
    }

    public int create(TicketPassageEntity entity) throws SQLException {
        return new TicketPassageDAOImpl().create(entity);
    }

    public int update(TicketPassageEntity entity) throws SQLException {
        return new TicketPassageDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new TicketPassageDAOImpl().delete(id);
    }
}
