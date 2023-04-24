package dao;

import org.example.entity.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class MovieDao {


    public Movie findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Movie.class, id);
    }

    public void save(Movie movie) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(movie);
        tx1.commit();
        session.close();
    }

    public void update(Movie movie) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(movie);
        tx1.commit();
        session.close();
    }

    public void delete(Movie movie) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(movie);
        tx1.commit();
        session.close();
    }

}
