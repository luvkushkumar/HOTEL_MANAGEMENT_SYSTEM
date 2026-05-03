package com.microservices.hotel.services;

import com.microservices.hotel.entities.Hotel;
import com.microservices.hotel.exception.ResourceNotFoundException;
import com.microservices.hotel.repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImp  implements  HotelService{

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("ID is not found"));
    }
}
