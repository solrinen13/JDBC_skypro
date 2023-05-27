package DAO;
import lombok.ToString;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtils;

import javax.persistence.*;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {


    @Override
    public void save(Employee employee) {

        try(Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee findById(Long id) {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            return session.get(Employee.class, id);
        }

    }

    @Override
    public void update(Employee employee) {
        try(Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteById(Employee employee) {
        try(Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();){
            Transaction transaction = session.beginTransaction();
           Query query = session.createNativeQuery("DELETE FROM employee WHERE id = :id");
           query.setParameter("id",employee.getId());
           query.executeUpdate();
           transaction.commit();

        }
    }

    @Override
    public List<Employee> findAll() {
        try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()){
            return session.createNativeQuery("SELECT * FROM employee",Employee.class).list();
        }
    }

}
