package iot.lviv.ua.DAO.implementation;

import iot.lviv.ua.DAO.EventDAO;
import iot.lviv.ua.model.EventEntity;
import iot.lviv.ua.model.EventEntity;
import iot.lviv.ua.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO {

    @Override
    public List<EventEntity> findAll() throws SQLException {
        List<EventEntity> entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<EventEntity>) session.createQuery("FROM iot.lviv.ua.model.EventEntity").list();
        }
        return entities;
    }

    @Override
    public EventEntity findById(Integer id) throws SQLException {
        EventEntity entity=null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (EventEntity) session.get(EventEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(EventEntity entity) throws SQLException {
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
    public int update(EventEntity entity) throws SQLException {
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
            EventEntity entity;
            entity = (EventEntity) session.load(EventEntity.class, id);
            session.delete(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
