package com.example.homework_06_05_tomcat.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            Configuration configuration =new Configuration();
            configuration.configure();
            sessionFactory= configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
