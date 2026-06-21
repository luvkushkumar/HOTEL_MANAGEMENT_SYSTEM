package com.microservices.user.service.Controller;


import com.microservices.user.service.entities.User;
import com.microservices.user.service.services.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        String randomId = UUID.randomUUID().toString(); //generate Unique_ID
        user.setUserId(randomId);
        User user1 = userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    //fetches single user
    @GetMapping("/{userId}")
    @CircuitBreaker(name="ratingservicebreaker",fallbackMethod = "ratingServiceFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable  String userId)
    {
        User user = userServices.getUser(userId);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> ratingServiceFallback(String userId,Exception ex)
    {
        logger.info("fallback method as been executed because rating service is down: ",ex.getMessage());
        User user = User.builder().name("dummy").email("dummy@gmail.com").userId("0000").build();

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> allUsers = userServices.getAllUser();
        return ResponseEntity.ok(allUsers);
    }

}
