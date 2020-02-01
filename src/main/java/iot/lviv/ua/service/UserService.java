package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.UserDAOImpl;
import iot.lviv.ua.model.UserEntity;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    public List<UserEntity> findAll() throws SQLException {
        return new UserDAOImpl().findAll();
    }

    public UserEntity findById(Integer id) throws SQLException {
        return new UserDAOImpl().findById(id);
    }

    public int create(UserEntity entity) throws SQLException {
        return new UserDAOImpl().create(entity);
    }

    public int update(UserEntity entity) throws SQLException {
        return new UserDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new UserDAOImpl().delete(id);
    }
}
