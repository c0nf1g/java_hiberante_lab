package iot.lviv.ua.DAO.implementation;

import iot.lviv.ua.DAO.OrderEventDAO;
import iot.lviv.ua.model.OrderEventEntity;
import iot.lviv.ua.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderEventDAOImpl implements OrderEventDAO {

    @Override
    public List<OrderEventEntity> findAll() throws SQLException {
        List<OrderEventEntity> entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<OrderEventEntity>) session.createQuery("FROM iot.lviv.ua.model.OrderEventEntity").list();
        }
        return entities;
    }

    @Override
    public OrderEventEntity findById(Integer id) throws SQLException {
        OrderEventEntity entity=null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (OrderEventEntity) session.get(OrderEventEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(OrderEventEntity entity) throws SQLException {
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
    public int update(OrderEventEntity entity) throws SQLException {
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
            OrderEventEntity entity;
            entity = (OrderEventEntity) session.load(OrderEventEntity.class, id);
            session.delete(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
