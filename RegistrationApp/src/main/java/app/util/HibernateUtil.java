package app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
    public static void closeSessionFactoryConnection() {
        if (sessionFactory != null) {
            sessionFactory.close();
        } else {
            System.out.println("Session factory not found");
        }
    }
}
