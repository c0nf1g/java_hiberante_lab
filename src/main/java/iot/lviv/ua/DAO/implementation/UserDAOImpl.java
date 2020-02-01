package iot.lviv.ua.DAO.implementation;

import iot.lviv.ua.DAO.UserDAO;
import iot.lviv.ua.model.UserEntity;
import iot.lviv.ua.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    
    @Override
    public List<UserEntity> findAll() throws SQLException {
        List<UserEntity> entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<UserEntity>) session.createQuery("FROM iot.lviv.ua.model.UserEntity").list();
        }
        return entities;
    }

    @Override
    public UserEntity findById(Integer id) throws SQLException {
        UserEntity entity=null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (UserEntity) session.get(UserEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(UserEntity entity) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int update(UserEntity entity) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            UserEntity entity;
            entity = (UserEntity) session.load(UserEntity.class, id);
            session.delete(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
