package iot.lviv.ua.DAO.implementation;

import iot.lviv.ua.DAO.OrderPassageDAO;
import iot.lviv.ua.model.OrderPassageEntity;
import iot.lviv.ua.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderPassageDAOImpl implements OrderPassageDAO {

    @Override
    public List<OrderPassageEntity> findAll() throws SQLException {
        List<OrderPassageEntity> entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<OrderPassageEntity>) session.createQuery("FROM iot.lviv.ua.model.OrderPassageEntity").list();
        }
        return entities;
    }

    @Override
    public OrderPassageEntity findById(Integer id) throws SQLException {
        OrderPassageEntity entity=null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (OrderPassageEntity) session.get(OrderPassageEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(OrderPassageEntity entity) throws SQLException {
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
    public int update(OrderPassageEntity entity) throws SQLException {
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
            OrderPassageEntity entity;
            entity = (OrderPassageEntity) session.load(OrderPassageEntity.class, id);
            session.delete(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
