//package com.example.spring_begin_07_06.util;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class HibernateUtil {
//    private static SessionFactory sessionFactory;
//    public static SessionFactory getSessionFactory(){
//        if(sessionFactory==null){
//            Configuration configuration =new Configuration();
//            configuration.configure();
//            sessionFactory= configuration.buildSessionFactory();
//        }
//        return sessionFactory;
//    }
//
//    public static Session openSession(){
//        return getSessionFactory().openSession();
//    }
//}

