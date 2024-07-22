package com.sguama.book_trip.application.interfaces;

import com.sguama.book_trip.domain.model.Flight;
import com.sguama.book_trip.infrastructure.entities.FlightEntity;

import java.util.List;

public interface IFlightRepository {

    Flight getFlightById(Long id);
    FlightEntity save(FlightEntity flightEntity);
    List<FlightEntity> getAllFlights();
}
