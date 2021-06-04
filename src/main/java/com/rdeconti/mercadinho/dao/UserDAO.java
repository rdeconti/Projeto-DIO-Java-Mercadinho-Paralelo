package com.rdeconti.mercadinho.dao;

import com.rdeconti.mercadinho.models.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public UserModel findUser(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.find(UserModel.class, userName);
    }

}
