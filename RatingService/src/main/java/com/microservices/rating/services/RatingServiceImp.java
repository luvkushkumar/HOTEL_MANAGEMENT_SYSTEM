package com.microservices.rating.services;

import com.microservices.rating.Repository.RatingRepo;
import com.microservices.rating.entities.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImp implements RatingService{

    @Autowired
    private RatingRepo ratingRepo;


    @Override
    public Rating create(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> getRatingByuserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }
}
