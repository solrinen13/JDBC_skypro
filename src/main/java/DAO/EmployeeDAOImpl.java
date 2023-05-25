package DAO;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtils;

import javax.persistence.*;
import java.util.List;

import static org.hibernate.criterion.Projections.id;

public class EmployeeDAOImpl implements EmployeeDAO {

private static SessionFactory sessionFactory;

    @Override
    public void save(Employee employee) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try(session){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }

    }
    @Override
    public Employee findById(Long id) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            return session.get(Employee.class, id());
        }

    }

    @Override
    public void update(Employee employee) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try(session){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Employee employee) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try(session){
            Transaction transaction = session.beginTransaction();
           Query query = session.createNativeQuery("DELETE FROM employee WHERE id = :id");
           query.setParameter("id",id());
           query.executeUpdate();
           transaction.commit();

        }
    }

    @Override
    public List<Employee> findAll() {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            return session.createNativeQuery("SELECT FROM employee").list();
        }
    }

}
