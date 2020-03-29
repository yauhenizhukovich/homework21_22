package com.gmail.supersonicleader.mvc.service;

import com.gmail.supersonicleader.mvc.service.model.UserDTO;

public interface UserService {

    boolean addUser(UserDTO user);

    UserDTO getUserByUsername(String username);

}
