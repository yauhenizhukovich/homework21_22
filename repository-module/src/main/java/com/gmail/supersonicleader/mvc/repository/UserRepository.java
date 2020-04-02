package com.gmail.supersonicleader.mvc.repository;

import com.gmail.supersonicleader.mvc.repository.model.User;

public interface UserRepository extends GenericRepository<Long, User> {

    User getUserByUsername(String username);

}
