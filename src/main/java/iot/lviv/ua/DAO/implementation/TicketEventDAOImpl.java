package iot.lviv.ua.DAO.implementation;

import iot.lviv.ua.DAO.TicketEventDAO;
import iot.lviv.ua.model.TicketEventEntity;
import iot.lviv.ua.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketEventDAOImpl implements TicketEventDAO {

    @Override
    public List<TicketEventEntity> findAll() throws SQLException {
        List<TicketEventEntity> entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<TicketEventEntity>) session.createQuery("FROM iot.lviv.ua.model.TicketEventEntity").list();
        }
        return entities;
    }

    @Override
    public TicketEventEntity findById(Integer id) throws SQLException {
        TicketEventEntity entity=null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (TicketEventEntity) session.get(TicketEventEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(TicketEventEntity entity) throws SQLException {
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
    public int update(TicketEventEntity entity) throws SQLException {
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
            TicketEventEntity entity;
            entity = (TicketEventEntity) session.load(TicketEventEntity.class, id);
            session.delete(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
