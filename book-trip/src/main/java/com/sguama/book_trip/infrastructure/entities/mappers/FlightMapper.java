package com.sguama.book_trip.infrastructure.entities.mappers;

import com.sguama.book_trip.domain.model.Flight;
import com.sguama.book_trip.infrastructure.entities.FlightEntity;

public class FlightMapper {

    public static Flight entityToDomain(FlightEntity flightEntity) {
        Flight flight = new Flight();
        flight.setId(flightEntity.getId());
        flight.setDestination(flightEntity.getDestination());
        flight.setOrigin(flightEntity.getOrigin());
        flight.setPrice(flightEntity.getPrice());
        return flight;
    }

    public static FlightEntity domainToEntity(Flight flight) {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setDestination(flight.getDestination());
        flightEntity.setOrigin(flight.getOrigin());
        flightEntity.setCapacity(flight.getCapacity());
        flightEntity.setId(flight.getId());
        flight.setPrice(flight.getPrice());
        return flightEntity;
    }


}
