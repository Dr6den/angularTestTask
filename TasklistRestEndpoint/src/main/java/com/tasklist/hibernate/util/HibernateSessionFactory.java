package com.tasklist.hibernate.util;

import com.model.entities.Task;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author andrew
 */
public class HibernateSessionFactory {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            Properties properties = new Properties();
            properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            properties.setProperty(Environment.HBM2DDL_AUTO, "update");
            properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.setProperty(Environment.USER, "mariadb");
            properties.setProperty(Environment.PASS, "mariadb");
            properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/tasklist?zeroDateTimeBehavior=convertToNull");
            Configuration c = new Configuration();
                  c.addAnnotatedClass(Task.class);
                  c.setProperties(properties);
                  sessionFactory = c.buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
