package com.gmail.supersonicleader.mvc.repository.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.gmail.supersonicleader.mvc.repository.UserRepository;
import com.gmail.supersonicleader.mvc.repository.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<Long, User> implements UserRepository {

    @Override
    public User getUserByUsername(String username) {
        String queryString = "FROM " + entityClass.getSimpleName() + " e WHERE e.username=:username";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("username", username);
        try {
            Object result = query.getSingleResult();
            return (User) result;
        } catch (NoResultException e) {
            return null;
        }
    }

}
