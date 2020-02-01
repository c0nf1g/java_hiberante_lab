package iot.lviv.ua.service;

import iot.lviv.ua.DAO.implementation.ArtistDAOImpl;
import iot.lviv.ua.model.ArtistEntity;

import java.sql.SQLException;
import java.util.List;

public class ArtistService {
    public List<ArtistEntity> findAll() throws SQLException {
        return new ArtistDAOImpl().findAll();
    }

    public ArtistEntity findById(Integer id) throws SQLException {
        return new ArtistDAOImpl().findById(id);
    }

    public int create(ArtistEntity entity) throws SQLException {
        return new ArtistDAOImpl().create(entity);
    }

    public int update(ArtistEntity entity) throws SQLException {
        return new ArtistDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new ArtistDAOImpl().delete(id);
    }
}
