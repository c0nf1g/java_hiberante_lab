package iot.lviv.ua.DAO;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAO<T, Integer> {
    List<T> findAll() throws SQLException;

    T findById(Integer id) throws SQLException;

    int create(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(Integer id) throws SQLException;
}
