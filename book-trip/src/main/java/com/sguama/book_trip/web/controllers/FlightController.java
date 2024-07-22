package com.sguama.book_trip.web.controllers;

import com.sguama.book_trip.application.services.FlightService;
import com.sguama.book_trip.infrastructure.entities.FlightEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/admin/create/v1")
    public ResponseEntity<FlightEntity> createFlight(@RequestBody FlightEntity flightEntity) {
        return new ResponseEntity<>(flightService.save(flightEntity), HttpStatus.CREATED);
    }

    @GetMapping("/list/v1")
    public List<FlightEntity> getAllActiveFlights() {
        return flightService.findAll();
    }
}
