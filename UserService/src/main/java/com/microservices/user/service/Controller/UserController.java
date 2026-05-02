package com.microservices.user.service.Controller;


import com.microservices.user.service.entities.User;
import com.microservices.user.service.services.UserServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        String randomId = UUID.randomUUID().toString(); //generate Unique_ID
        user.setUserId(randomId);
        User user1 = userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable  String userId)
    {
        User user = userServices.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> allUsers = userServices.getAllUser();
        return ResponseEntity.ok(allUsers);
    }

}
