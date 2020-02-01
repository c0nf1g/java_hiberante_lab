package iot.lviv.ua.DAO.implementation;

import iot.lviv.ua.DAO.PassageDAO;
import iot.lviv.ua.model.PassageEntity;
import iot.lviv.ua.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassageDAOImpl implements PassageDAO {

    @Override
    public List<PassageEntity> findAll() throws SQLException {
        List<PassageEntity> entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<PassageEntity>) session.createQuery("FROM iot.lviv.ua.model.PassageEntity").list();
        }
        return entities;
    }

    @Override
    public PassageEntity findById(Integer id) throws SQLException {
        PassageEntity entity=null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (PassageEntity) session.get(PassageEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(PassageEntity entity) throws SQLException {
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
    public int update(PassageEntity entity) throws SQLException {
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
            PassageEntity entity;
            entity = (PassageEntity) session.load(PassageEntity.class, id);
            session.delete(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
