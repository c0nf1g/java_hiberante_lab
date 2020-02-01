package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.CredentialDAOImpl;
import iot.lviv.ua.model.CredentialEntity;

import java.sql.SQLException;
import java.util.List;

public class CredentialService {
    public List<CredentialEntity> findAll() throws SQLException {
        return new CredentialDAOImpl().findAll();
    }

    public CredentialEntity findById(Integer id) throws SQLException {
        return new CredentialDAOImpl().findById(id);
    }

    public int create(CredentialEntity entity) throws SQLException {
        return new CredentialDAOImpl().create(entity);
    }

    public int update(CredentialEntity entity) throws SQLException {
        return new CredentialDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new CredentialDAOImpl().delete(id);
    }
}
