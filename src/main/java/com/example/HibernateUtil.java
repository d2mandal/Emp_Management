package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("dbInfo.xml")
                    .addAnnotatedClass(Employee.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Failed to build SessionFactory", e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}