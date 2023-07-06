package com.example.spring_begin_07_06.dao.impl;

import com.example.spring_begin_07_06.dao.UserDao;
import com.example.spring_begin_07_06.model.User;
import com.example.spring_begin_07_06.model.command.UserUpdateCommand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.from(User.class);
        List<User> users = session.createQuery(criteria).getResultList();
        transaction.commit();
        session.close();
        return users;
    }
    public Optional<User> findUserByUserName(String username){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Query<User> query = session.createNamedQuery("User.findByUserName", User.class);
        query.setParameter("username",username);
        Optional<User> user = query.uniqueResultOptional();
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUserById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUserById(Long id, UserUpdateCommand command) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        user.setUsername(command.getUsername());
        user.setFirstName(command.getFirstName());
        user.setLastName(command.getLastName());
        user.setEmail(command.getEmail());
        user.setAddress(command.getAddress());
        user.setDate(command.getDate());
        transaction.commit();
        session.close();
    }
}
