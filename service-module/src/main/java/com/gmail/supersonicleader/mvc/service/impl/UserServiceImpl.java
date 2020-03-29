package com.gmail.supersonicleader.mvc.service.impl;

import com.gmail.supersonicleader.mvc.repository.UserRepository;
import com.gmail.supersonicleader.mvc.repository.model.RoleEnum;
import com.gmail.supersonicleader.mvc.repository.model.User;
import com.gmail.supersonicleader.mvc.service.UserService;
import com.gmail.supersonicleader.mvc.service.model.UserDTO;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    @Transactional
    public boolean addUser(UserDTO userDTO) {
        String username = userDTO.getUsername();
        if (userRepository.getUserByUsername(username) != null) {
            return false;
        }
        User user = convertDTOToDatabaseObject(userDTO);
        userRepository.add(user);
        return true;
    }

    @Override
    @Transactional
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.getUserByUsername(username);
        return convertDatabaseObjectToDTO(user);
    }

    private UserDTO convertDatabaseObjectToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        String username = user.getUsername();
        userDTO.setUsername(username);
        String password = user.getPassword();
        userDTO.setPassword(password);
        RoleEnum role = user.getRole();
        userDTO.setRole(role);
        return userDTO;
    }

    private User convertDTOToDatabaseObject(UserDTO userDTO) {
        User user = new User();
        String username = userDTO.getUsername();
        user.setUsername(username);
        String password = userDTO.getPassword();
        String bCryptPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(bCryptPassword);
        user.setRole(RoleEnum.USER);
        return user;
    }

}
