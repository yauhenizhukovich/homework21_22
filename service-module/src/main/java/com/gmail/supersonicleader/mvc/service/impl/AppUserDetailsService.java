package com.gmail.supersonicleader.mvc.service.impl;

import java.lang.invoke.MethodHandles;

import com.gmail.supersonicleader.mvc.service.UserService;
import com.gmail.supersonicleader.mvc.service.model.AppUser;
import com.gmail.supersonicleader.mvc.service.model.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final UserService userService;

    public AppUserDetailsService(UserService userService) {this.userService = userService;}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userService.getUserByUsername(username);
        if (user == null) {
            logger.info("User '" + username + "' was not found");
            throw new UsernameNotFoundException("User '" + username + "' was not found");
        }
        return new AppUser(user);
    }

}
