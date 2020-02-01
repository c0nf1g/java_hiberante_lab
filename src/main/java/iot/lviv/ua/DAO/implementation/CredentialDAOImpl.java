package iot.lviv.ua.DAO.implementation;

import iot.lviv.ua.DAO.CredentialDAO;
import iot.lviv.ua.model.CredentialEntity;
import iot.lviv.ua.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredentialDAOImpl implements CredentialDAO {

    @Override
    public List<CredentialEntity> findAll() throws SQLException {
        List<CredentialEntity> entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<CredentialEntity>) session.createQuery("FROM iot.lviv.ua.model.CredentialEntity").list();
        }
        return entities;
    }


    @Override
    public CredentialEntity findById(Integer id) throws SQLException {
        CredentialEntity entity=null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (CredentialEntity) session.get(CredentialEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(CredentialEntity entity) throws SQLException {
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
    public int update(CredentialEntity entity) throws SQLException {
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
            CredentialEntity entity;
            entity = (CredentialEntity) session.load(CredentialEntity.class, id);
            session.delete(entity);
            transaction.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
