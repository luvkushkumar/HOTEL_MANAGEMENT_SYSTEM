package com.microservices.user.service.services;

import com.microservices.user.service.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;



public interface UserServices {

    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}
