package iot.lviv.ua.DAO.implementation;

import iot.lviv.ua.DAO.TicketPassageDAO;
import iot.lviv.ua.model.TicketPassageEntity;
import iot.lviv.ua.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketPassageDAOImpl implements TicketPassageDAO {

    @Override
    public List<TicketPassageEntity> findAll() throws SQLException {
        List<TicketPassageEntity> entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<TicketPassageEntity>) session.createQuery("FROM iot.lviv.ua.model.TicketPassageEntity").list();
        }
        return entities;
    }

    @Override
    public TicketPassageEntity findById(Integer id) throws SQLException {
        TicketPassageEntity entity=null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (TicketPassageEntity) session.get(TicketPassageEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(TicketPassageEntity entity) throws SQLException {
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
    public int update(TicketPassageEntity entity) throws SQLException {
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
            TicketPassageEntity entity;
            entity = (TicketPassageEntity) session.load(TicketPassageEntity.class, id);
            session.delete(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
