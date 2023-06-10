package utils;

import model.City;
import model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration conf = new Configuration().configure("META-INF/persistence.cfg.xml");
            conf.addAnnotatedClass(Employee.class);
            conf.addAnnotatedClass(City.class);
            sessionFactory = conf.buildSessionFactory(
                    new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build()
            );

        }
        return sessionFactory;
    }
}
