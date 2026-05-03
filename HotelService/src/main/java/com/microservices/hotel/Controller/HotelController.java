package com.microservices.hotel.Controller;

import com.microservices.hotel.entities.Hotel;
import com.microservices.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        String randomId = UUID.randomUUID().toString();
        hotel.setHotelId(randomId);
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getById(@PathVariable  String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
    }
}
