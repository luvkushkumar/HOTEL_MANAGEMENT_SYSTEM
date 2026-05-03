package com.microservices.rating.Repository;

import com.microservices.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating,String> {

    List<Rating> findByHotelId(String hotelId);
    List<Rating> findByUserId(String userId);
}
