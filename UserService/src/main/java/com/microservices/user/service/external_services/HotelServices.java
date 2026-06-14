package com.microservices.user.service.external_services;

import com.microservices.user.service.entities.Hotel;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTELSERVICE")
public interface HotelServices {

    @GetMapping("/hotel/{hotelId}")
    Hotel getHotels(@PathVariable String hotelId);



}
