package com.example.spring_begin_07_06.dao.impl;

import com.example.spring_begin_07_06.dao.RoleDao;
import com.example.spring_begin_07_06.model.Role;
import com.example.spring_begin_07_06.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Optional<Role> findRoleByName(String name){
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Query<Role> query = session.createNamedQuery("Role.findByName", Role.class);
        query.setParameter("name",name);
        Optional<Role> role = query.uniqueResultOptional();
        transaction.commit();
        session.close();
        return role;
    }
}
