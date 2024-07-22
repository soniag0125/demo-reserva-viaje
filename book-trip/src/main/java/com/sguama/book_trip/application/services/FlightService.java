package com.sguama.book_trip.application.services;

import com.sguama.book_trip.application.interfaces.IFlightRepository;
import com.sguama.book_trip.infrastructure.entity.FlightEntity;
import com.sguama.book_trip.web.controllers.FlightController;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FlightService  {

    private final IFlightRepository repositoryFlights;

    public FlightService(IFlightRepository repositoryFlights) {
        this.repositoryFlights = repositoryFlights;
    }

    public FlightEntity save(FlightEntity flight) {
        return repositoryFlights.save(flight);
    }

    public List<FlightEntity> findAll() {

        return repositoryFlights.getAllFlights();
    }


}
