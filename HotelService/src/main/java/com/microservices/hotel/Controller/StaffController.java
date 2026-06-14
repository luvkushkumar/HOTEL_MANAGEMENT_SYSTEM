package com.microservices.hotel.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @GetMapping
    public ResponseEntity<List<String>> getStaffs()
    {
        return ResponseEntity.ok(
                List.of("Lovkush", "Manish", "Pop")
        );
    }

}
