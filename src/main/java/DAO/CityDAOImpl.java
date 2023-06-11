package DAO;


import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtils;

import java.util.List;


public class CityDAOImpl implements CityDAO {
    @Override
    public City add(City city) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public City findById(int id) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> findAll() {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            return session.createQuery("FROM City").getResultList();
        }

    }

    @Override
    public City update(City city) {
        City updated;
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updated = (City) session.merge(city);
            transaction.commit();
        }
        return updated;

    }


    @Override
    public void delete(City city) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
