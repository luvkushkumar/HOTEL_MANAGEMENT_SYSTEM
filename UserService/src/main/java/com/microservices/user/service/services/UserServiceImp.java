package com.microservices.user.service.services;

import com.microservices.user.service.entities.Hotel;
import com.microservices.user.service.entities.Rating;
import com.microservices.user.service.entities.User;
import com.microservices.user.service.exceptions.ResourceNotFoundException;
import com.microservices.user.service.external_services.HotelServices;
import com.microservices.user.service.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserServices{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServices hotelServices;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        //fetches the user from database.
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on the server !! "+userId));
        Rating[] ratingOfUser = restTemplate.getForObject("http://RATINGSERVICE/rating/userId/"+user.getUserId(), Rating[].class);
        List<Rating> ratingOfUsers =      Arrays.stream(ratingOfUser).toList();
        List<Rating>ratingList =  ratingOfUsers.stream().map(rating -> {

//            ResponseEntity<Hotel> hotels = restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = hotels.getBody();
            Hotel  hotel = hotelServices.getHotels(rating.getHotelId());
//          logger.info("response status code is {}",hotels.getStatusCode());
          rating.setHotel(hotel);
          return rating ;
        }).collect(Collectors.toList());


        user.setRatings(ratingList);
        return user;

    }
}
