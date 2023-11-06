package com.example.saqaya.repository.impl;


import com.example.saqaya.model.User;
import com.example.saqaya.model.UserDetails;
import com.example.saqaya.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {
    @Autowired
    EntityManager entityManager;
    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User findByEmailAddress(String email) {
        TypedQuery<User> query=entityManager.createQuery("from User where email=?1",User.class);

        query.setParameter(1,email);

        User user=query.getSingleResult();

        return user;
    }

    @Override
    @Transactional
    public User getUserById(String id) {

        TypedQuery<User> query=entityManager.createQuery("from User where id=?1",User.class);

        query.setParameter(1,id);

        User user=query.getSingleResult();

        return user;
    }

    @Override
    @Transactional
    public void saveUserDetails(UserDetails userDetails) {
        entityManager.merge(userDetails);
    }

    @Override
    public List<UserDetails> getUserDetailsById(String id) throws Exception {
        TypedQuery<UserDetails> query=entityManager.createQuery("from UserDetails where id=?1",UserDetails.class);
      List<  UserDetails> userDetails=null;
        query.setParameter(1,id);

    userDetails = query.getResultList();


return userDetails;
    }
}
