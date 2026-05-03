package com.microservices.rating.services;

import com.microservices.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByHotelId(String hotelId);

    List<Rating> getRatingByuserId(String userId);

}
