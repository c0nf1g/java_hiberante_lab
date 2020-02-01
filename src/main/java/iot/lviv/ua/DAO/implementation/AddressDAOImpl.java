package iot.lviv.ua.DAO.implementation;

import iot.lviv.ua.DAO.AddressDAO;
import iot.lviv.ua.model.AddressEntity;
import iot.lviv.ua.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {

    @Override
    public List<AddressEntity> findAll() throws SQLException {
        List<AddressEntity> entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<AddressEntity>) session.createQuery("FROM iot.lviv.ua.model.AddressEntity").list();
        }
        return entities;
    }

    @Override
    public AddressEntity findById(Integer id) throws SQLException {
        AddressEntity entity=null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (AddressEntity) session.get(AddressEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(AddressEntity entity) throws SQLException {
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
    public int update(AddressEntity entity) throws SQLException {
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
            AddressEntity entity;
            entity = (AddressEntity) session.load(AddressEntity.class, id);
            session.delete(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
