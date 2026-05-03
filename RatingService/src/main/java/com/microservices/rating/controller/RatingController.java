package com.microservices.rating.controller;

import com.microservices.rating.entities.Rating;
import com.microservices.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        String randomId = UUID.randomUUID().toString();
        rating.setRatingId(randomId);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings()
    {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/hotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable  String hotelId)
    {
        return  ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable  String userId)
    {
        return ResponseEntity.ok(ratingService.getRatingByuserId(userId));
    }
}
